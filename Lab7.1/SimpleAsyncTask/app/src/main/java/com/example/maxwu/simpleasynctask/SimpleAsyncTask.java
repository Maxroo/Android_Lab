package com.example.maxwu.simpleasynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<String,String,String> {
    private WeakReference<TextView> mTextView;
    private String resp;
    private Context mainActivity;
    private TextView mResultTV;
    ProgressDialog progressDialog;
    ProgressBar progressBar;
    int progress = 0;

    SimpleAsyncTask(TextView tv, Context mainActivity, ProgressBar progressBar) {
        mTextView = new WeakReference<>(tv);
        this.mainActivity = mainActivity;
        mResultTV = tv;
        this.progressBar = progressBar;
    }

    @Override
    protected String doInBackground(String... voids) {


        try {
            int timems = 5;
            for(int i = 1; i <= timems; i++) {
                Thread.sleep(1000);
                publishProgress("Remaining... " + (timems - i)); // Calls onProgressUpdate()
                resp = "Slept for " + 5 + " seconds";
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            resp = e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            resp = e.getMessage();
        }
        return resp;
    }


    @Override
    protected void onPostExecute(String result) {

        progressDialog.dismiss();
        mResultTV.setText(result);
    }


    @Override
    protected void onPreExecute() {
        // Main thread
        progressDialog = ProgressDialog.show(mainActivity,
                "ProgressDialog",
                "Wait for "+ 5+ " seconds");
    }


    @Override
    protected void onProgressUpdate(String... text) {
        // Main thread
        progressDialog.setMessage(text[0]);
        mResultTV.setText(text[0]);
        progress += 20;
        progressBar.setProgress(progress,true);
    }
}

