package com.eevoskos.android_peristence_tests;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.eevoskos.android_peristence_tests.cupboard.CupboardReadTest;
import com.eevoskos.android_peristence_tests.cupboard.CupboardWriteTest;
import com.eevoskos.android_peristence_tests.realm.RealmReadTest;
import com.eevoskos.android_peristence_tests.realm.RealmWriteTest;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    @InjectView(R.id.list)
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        List<String> data = new ArrayList<String>();
        data.add("Cupboard write (10K)");
        data.add("Cupboard read (all)");
        data.add("Realm write (10K)");
        data.add("Realm read (all)");

        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, data));
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Class<?> klass;
        switch (position) {
            case 0:
                klass = CupboardWriteTest.class;
                break;
            case 1:
                klass = CupboardReadTest.class;
                break;
            case 2:
                klass = RealmWriteTest.class;
                break;
            case 3:
                klass = RealmReadTest.class;
                break;
            default:
                klass = null;
                break;
        }
        startActivity(new Intent(this, klass));
    }

}
