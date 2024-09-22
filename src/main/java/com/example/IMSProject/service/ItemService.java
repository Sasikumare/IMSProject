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
        try{
            return itemRepository.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to fetch Items:" +e);
        }
    }


    public String addInventoryItems(Item item) {
       try{
           itemRepository.save(item);
           return "Item Saved Successfully : "+ item.getItemName();
       } catch (RuntimeException e) {
           throw new RuntimeException("Failed to add new Item:" +e);
       }
    }

    public String updateItems(Item item, int itemId) {

        try {
            if (itemRepository.findById(itemId).isPresent()) {
                item.setItemId(itemId);
                itemRepository.save(item);
                return item.getItemName() + " Item Updated Successfully";
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to Update the Item: " +e);
        }
        return "Item Not Found";
    }

    public String deleteItems(int itemId) {
        try {
            if (itemRepository.findById(itemId).isPresent()) {
                itemRepository.deleteById(itemId);
                return "Item Deleted Successfully";
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to Delete the Item: " +e);
        }
        return  "Item Not Found";
    }

    public Item getItembyItemName(String itemName) {
        try {
            return  itemRepository.getByItemName(itemName);
        }catch (Exception e){
            throw  new RuntimeException("Failed to fetch the Items:"+ e);
        }

    }
}
