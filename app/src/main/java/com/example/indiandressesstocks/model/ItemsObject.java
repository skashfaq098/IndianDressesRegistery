package com.example.indiandressesstocks.model;

import java.util.ArrayList;

public class ItemsObject {
    public String ItemName,ItemPrice,ItemQty;
    public ItemsObject(String ItemName, String ItemPrice, String ItemQty) {
        this.ItemName=ItemName;
        this.ItemPrice=ItemPrice;
        this.ItemQty=ItemQty;

    }

    public String getItemName() {
        return ItemName;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public String getItemQty() {
        return ItemQty;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public void setItemPrice(String itemPrice) {
        ItemPrice = itemPrice;
    }

    public void setItemQty(String itemQty) {
        ItemQty = itemQty;
    }
}
