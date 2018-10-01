package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.view.View;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;

import java.io.IOException;

import b.udacity.reshu.androidlibrary.JokesActivity;

/**
 * Created by lenovo-pc on 9/26/2018.
 */
public class EndPointAsyncTask extends android.os.AsyncTask<Pair<Context, String>, Void, String> {
        private static MyApi myApiService = null;
        private Context context;
        private String TAG = "Background";
        private View progressBar;

        public EndPointAsyncTask(Context context,View progressBar){
            this.context = context;
            this.progressBar = progressBar;
        }

    public EndPointAsyncTask(Object o) {
    }

    @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (progressBar != null) {
                progressBar.setVisibility(View.VISIBLE);
            }
        }

        @Override
        protected String doInBackground(Pair<Context, String>... params) {
            Log.i(TAG, "doInBackground: ");
            if(myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        .setRootUrl("http://10.0.2.2:8080/_ah/api/");

                myApiService = builder.build();
            }

            try {
                MyBean myBean = myApiService.sayJoke().execute();
                return myBean.getData();
            } catch (IOException e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            progressBar.setVisibility(View.GONE);
            Intent intent = new Intent(context, JokesActivity.class);
            intent.putExtra("get_joke", result);
            context.startActivity(intent);
        }


}

