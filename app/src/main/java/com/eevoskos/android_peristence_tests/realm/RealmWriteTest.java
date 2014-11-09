package com.eevoskos.android_peristence_tests.realm;

import com.eevoskos.android_peristence_tests.TestActivity;

import io.realm.Realm;

import static com.eevoskos.android_peristence_tests.Config.ITEMS_PER_RUN;

public class RealmWriteTest extends TestActivity {

    @Override
    public void onRun(int itemsPerRun) {
        Realm realm = Realm.getInstance(RealmWriteTest.this, false);
        realm.beginTransaction();

        for (int i = 0; i < ITEMS_PER_RUN; i++) {
            Item item = realm.createObject(Item.class);
            item.setName("Item #" + i);
            item.setValue(i);
        }
        realm.commitTransaction();
    }

}
