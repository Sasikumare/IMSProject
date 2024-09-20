package com.example.IMSProject.controller;


import com.example.IMSProject.model.Item;
import com.example.IMSProject.repository.ItemRepository;
import com.example.IMSProject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemService itemService;

    @GetMapping("/allItems")
    public List<Item> getAllItems(){
        return itemService.getItems();
    }

    @PostMapping("/addItem")
    public String addItem(@RequestBody Item item){
        return itemService.addInventoryItems(item);
    }

    @PutMapping("/updateItem/{itemId}")
    public String updateItem(@RequestBody Item item, @PathVariable int itemId){
            return itemService.updateItems(item,itemId);
    }

    @DeleteMapping("/deleteItem/{itemId}")
    public String deleteItem(@PathVariable int itemId){
        return itemService.deleteItems(itemId);
    }

    @GetMapping("/{itemName}")
    public Item getItemByName(@PathVariable String itemName){
        return itemService.getItembyItemName(itemName);
    }
}
