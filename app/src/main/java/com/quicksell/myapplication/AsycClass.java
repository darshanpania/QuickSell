package com.quicksell.myapplication;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Darshan on 16-04-2017.
 */
public class AsycClass implements MyThreadListener {
    String string="";
    public  AsycClass(){

    }

    @Override
    public void threadFinished() {

    }

    public void onPreExecute(){

    }

    public String doInBackground(String... params){
        return null;
    }

    public void onPostExecute(String string){



    }

    public void execute(final String... params){
        onPreExecute();
        final MyThreadListener listener = new MyThreadListener() {
            @Override
            public void threadFinished() {
              onPostExecute(string);
            }
        };
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    string = doInBackground(params);
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            listener.threadFinished();
                        }
                    });

                }
            });
            thread.start();
            //thread.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        //onPostExecute(string);
    }

}
