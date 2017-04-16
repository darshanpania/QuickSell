package com.quicksell.myapplication;

/**
 * Created by Darshan on 16-04-2017.
 */
public class AsycClass {
    String string="";
    public  AsycClass(){

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
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
              string  = doInBackground(params);
            }
        });
        thread.start();

        onPostExecute(string);
    }
}
