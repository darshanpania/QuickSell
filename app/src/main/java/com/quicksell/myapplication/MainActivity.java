package com.quicksell.myapplication;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    TextView textView, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        String[] objects = {"1", "2", "3"};
        myTask myTask = new myTask(this);
        myTask.execute(objects);
    }

    public class myTask extends AsycClass {
        String param = "";
        Activity activity;

        public myTask(Activity activity) {
            this.activity = activity;
        }

        @Override
        public void onPreExecute() {
            super.onPreExecute();
            textView.setText("Inside Pre Execute"+ Thread.currentThread().getName());
        }

        @Override
        public String doInBackground(String... params) {

            for (int i = 0; i < params.length; i++) {
                param += params[i];
            }
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textView2.setVisibility(View.VISIBLE);
                    textView2.setText("inside do in background"+ Thread.currentThread().getName());
                }
            });
            return param;

        }

        @Override
        public void onPostExecute(String params) {
            super.onPostExecute(params);
            textView3.setVisibility(View.VISIBLE);
            textView3.setText("Inside On Post Execute " + param + Thread.currentThread().getName());
        }
    }
}
