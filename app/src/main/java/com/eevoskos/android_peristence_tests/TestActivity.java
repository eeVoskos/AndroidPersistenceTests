package com.eevoskos.android_peristence_tests;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import timber.log.Timber;

import static com.eevoskos.android_peristence_tests.Config.ITEMS_PER_RUN;
import static com.eevoskos.android_peristence_tests.Config.NUMBER_OF_RUNS;

public abstract class TestActivity extends Activity {

    private ListView list;
    private ArrayAdapter<TestResult> adapter;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        adapter = new ArrayAdapter<TestResult>(this, android.R.layout.simple_list_item_1);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                new TestRunTask().execute(NUMBER_OF_RUNS, ITEMS_PER_RUN);
            }
        }, 200);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    public void onPreRun() {
        // Do nothing
    }

    public abstract void onRun(int itemsPerRun);
    public abstract void startTest();
    public abstract void stopTest();

    class TestRunTask extends AsyncTask<Integer, Long, Void> {

        private List<TestResult> results = new ArrayList<TestResult>();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            onPreRun();
        }

        @Override
        protected Void doInBackground(Integer... params) {
            int numberOfRuns = params[0];
            int itemsPerRun = params[1];

            startTest();
            for (int i = 0; i < numberOfRuns; i++) {
                long start = System.nanoTime();
                onRun(itemsPerRun);
                long end = System.nanoTime();
                long dt = TimeUnit.NANOSECONDS.toMillis(end - start);
                publishProgress(dt);
            }
            stopTest();

            return null;
        }

        @Override
        protected void onProgressUpdate(Long... progress) {
            super.onProgressUpdate(progress);
            TestResult result = new TestResult(progress[0]);
            results.add(result);
            adapter.add(result);
            list.post(new Runnable() {
                @Override
                public void run() {
                    list.smoothScrollToPosition(list.getCount() - 1);
                }
            });
        }

        @Override
        protected void onPostExecute(Void duration) {
            super.onPostExecute(duration);

            long sum = 0;
            for (TestResult res : results) {
                sum += res.duration;
            }
            long average = sum / results.size();

            Timber.d("Average: %d ms", average);
            Toast.makeText(TestActivity.this, average + " ms average", Toast.LENGTH_LONG).show();

        }
    }

}
