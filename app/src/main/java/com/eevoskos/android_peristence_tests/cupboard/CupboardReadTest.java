package com.eevoskos.android_peristence_tests.cupboard;

import android.database.sqlite.SQLiteDatabase;

import com.eevoskos.android_peristence_tests.TestActivity;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class CupboardReadTest extends TestActivity {

    @Override
    public void onRun(int itemsPerRun) {
        SQLiteDatabase db = new CupboardSQLiteOpenHelper(CupboardReadTest.this).getWritableDatabase();
        cupboard().withDatabase(db).query(Item.class).query();
        db.close();
    }

}
