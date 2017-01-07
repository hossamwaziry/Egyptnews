package com.hossam.egyptnews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hossam.egyptnews.dataProccess.Connector;
import com.hossam.egyptnews.dataProccess.DataEncap;
import com.hossam.egyptnews.dataProccess.JsonParser;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    final static String api = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Connector connector = new Connector();

        try {

            JsonParser parser = new JsonParser();

            ArrayList<DataEncap> arrayList = parser.JsonProcess(connector.execute(api).get());

            for (int i = 0; i < arrayList.size(); i++) {

                System.out.println(arrayList.get(i).getTitle());
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
