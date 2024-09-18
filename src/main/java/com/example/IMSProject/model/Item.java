package com.example.IMSProject.model;


import jakarta.persistence.*;


@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    @Column
    private String itemName;
    @Column
    private long itemPrice;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(long itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Item(int itemId, String itemName, long itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
