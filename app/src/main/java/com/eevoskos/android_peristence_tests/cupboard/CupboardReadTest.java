package com.eevoskos.android_peristence_tests.cupboard;

import android.database.sqlite.SQLiteDatabase;

import com.eevoskos.android_peristence_tests.TestActivity;

import nl.qbusict.cupboard.QueryResultIterable;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class CupboardReadTest extends TestActivity {

    private SQLiteDatabase db;

    @Override
    public void onRun(int itemsPerRun) {
        QueryResultIterable<Item> result = cupboard().withDatabase(db).query(Item.class).query();
        for (Item item : result) {
            item.getName();
        }
    }

    @Override
    public void startTest() {
        db = new CupboardSQLiteOpenHelper(CupboardReadTest.this).getWritableDatabase();
    }

    @Override
    public void stopTest() {
        db.close();
    }
}
