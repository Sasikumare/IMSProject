package com.example.IMSProject.service;


import com.example.IMSProject.model.Item;
import com.example.IMSProject.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public List<Item> getItems() {
        return itemRepository.findAll();
    }


    public String addInventoryItems(Item item) {
        itemRepository.save(item);
        return "Item Saved Successfully";
    }

    public String updateItems(Item item, int itemId) {
        if(itemRepository.findById(itemId).isPresent()){
            item.setItemId(itemId);
            itemRepository.save(item);
            return "Updated Item Successfully";
        }
        throw new RuntimeException("Item not Found");
    }

    public String deleteItems(int itemId) {
        if(itemRepository.findById(itemId).isPresent()){
            itemRepository.deleteById(itemId);
            return "Item Deleted Successfully";
        }
        throw new RuntimeException("Item not Found");
    }
}
