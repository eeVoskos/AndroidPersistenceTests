package com.eevoskos.android_peristence_tests.cupboard;

import android.database.sqlite.SQLiteDatabase;

import com.eevoskos.android_peristence_tests.ItemInterface;
import com.eevoskos.android_peristence_tests.TestActivity;

import java.util.ArrayList;
import java.util.List;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class CupboardWriteTest extends TestActivity {

    private SQLiteDatabase db;

    @Override
    public void onRun(int itemsPerRun) {
        List<ItemInterface> items = new ArrayList<ItemInterface>();
        for (int i = 0; i < itemsPerRun; i++) {
            Item item = new Item();
            item.setName("Item #" + i);
            item.setValue(i);
            items.add(item);
        }
        cupboard().withDatabase(db).put(items);
    }

    @Override
    public void startTest() {
        db = new CupboardSQLiteOpenHelper(CupboardWriteTest.this).getWritableDatabase();
    }

    @Override
    public void stopTest() {
        db.close();
    }
}
