package com.example.indiandressesstocks.model;

import java.util.ArrayList;

public class ItemsObject {
    public String range,majorDimension;
    ArrayList<Items> values;

    public ItemsObject(){
    }
    public ItemsObject(String range, String majorDimension, ArrayList<Items> values) {
        this.range=range;
        this.majorDimension=majorDimension;
        this.values=values;
    }

    public ArrayList<Items> getValues() {
        return values;
    }

    public String getMajorDimension() {
        return majorDimension;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public void setMajorDimension(String majorDimension) {
        this.majorDimension = majorDimension;
    }

    public void setValues(ArrayList<Items> values) {
        this.values = values;
    }
}
class Items{
    public String ItemName,ItemPrice,ItemQty;
    public Items(String ItemName, String ItemPrice, String ItemQty) {
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

