package com.example.myrealestateproject;

import java.util.ArrayList;
import java.util.HashMap;

// a controller class with a static instance
public class SceneController {
    private static final int DATABASE_CAPACITY = 100;
    private static SceneController instance = null;
    private ArrayList<String> dataList;
    public KonutPriorityQueue konutPriorityQueue = new KonutPriorityQueue(DATABASE_CAPACITY);
    private static HashMap<String, ArrayList<String>> dataMap = new HashMap<>();
    private SceneController() {
        dataList = new ArrayList<>();
    }

    public static SceneController getInstance() {
        if (instance == null) {
            instance = new SceneController();
        }
        return instance;
    }

    // method to add user preferred choices to dataMap
    public void addStringToKey(String key, String value) {

        ArrayList<String> values;
        if (dataMap != null && dataMap.containsKey(key)) {
            values = dataMap.get(key);
        } else {
            values = new ArrayList<>();
        }
        values.add(value);
        dataMap.put(key, values);
    }

    public ArrayList<String> getDataList() {
        return dataList;
    }
    public HashMap<String, ArrayList<String>> getDataMap() {
        return dataMap;
    }
}