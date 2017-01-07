package com.hossam.egyptnews.dataProccess;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by hossam on 1/7/17.
 */

public class JsonParser {

    ArrayList<DataEncap> data;

    public ArrayList<DataEncap> JsonProcess(String jsonFile) {

        data = new ArrayList<>();

        try {

            JSONObject mainObject = new JSONObject(jsonFile);

            JSONArray jsonArray = mainObject.getJSONArray("articles");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject mainObjectArray = jsonArray.getJSONObject(i);

                DataEncap encap = new DataEncap(mainObjectArray.getString(KeyTags.urlKey),
                        mainObjectArray.getString(KeyTags.imgKey), mainObjectArray.getString(KeyTags.descKey), mainObjectArray.getString(KeyTags.titleKey));

                data.add(encap);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ArrayList<DataEncap> getlist() {
        return data;
    }
}
