package com.eevoskos.android_peristence_tests.realm;

import com.eevoskos.android_peristence_tests.TestActivity;

import io.realm.Realm;

public class RealmReadTest extends TestActivity {

    @Override
    public void onRun(int itemsPerRun) {
        Realm realm = Realm.getInstance(RealmReadTest.this, false);
        realm.where(Item.class).findAll();
    }

}
