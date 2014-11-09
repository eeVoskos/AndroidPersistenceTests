package com.eevoskos.android_peristence_tests.realm;

import com.eevoskos.android_peristence_tests.ItemInterface;

import io.realm.RealmObject;

public class Item extends RealmObject implements ItemInterface {

    private String name;
    private int value;

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
