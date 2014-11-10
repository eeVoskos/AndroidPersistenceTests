package com.eevoskos.android_peristence_tests.realm;

import com.eevoskos.android_peristence_tests.TestActivity;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmReadTest extends TestActivity {

    private Realm realm;

    @Override
    public void onRun(int itemsPerRun) {
        RealmResults<Item> result = realm.where(Item.class).findAll();
        for (Item item : result) {
            item.getName();
        }
    }

    @Override
    public void startTest() {
        realm = Realm.getInstance(RealmReadTest.this, false);
    }

    @Override
    public void stopTest() {
        // No need to close a Realm
    }
}
