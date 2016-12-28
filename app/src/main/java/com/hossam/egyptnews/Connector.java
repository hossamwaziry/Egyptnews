package com.hossam.egyptnews;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hossam on 12/27/16.
 */

public class Connector extends AsyncTask<String, String, String> {

    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    String data;

    @Override
    protected String doInBackground(String... params) {

        try {

            StringBuffer buffer = new StringBuffer();

            URL url = new URL(params[0]);

            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";

            while ((line = reader.readLine()) != null) {

                buffer.append(line + "\n");
            }

            data = buffer.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }


}

