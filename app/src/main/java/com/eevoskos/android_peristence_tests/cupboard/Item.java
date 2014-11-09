package com.eevoskos.android_peristence_tests.cupboard;

import com.eevoskos.android_peristence_tests.ItemInterface;

public class Item implements ItemInterface {

    private Long _id;

    public String name;
    public int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public Item() {
        super();
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
