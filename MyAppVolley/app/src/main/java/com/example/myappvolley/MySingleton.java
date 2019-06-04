package com.example.myappvolley;

import com.android.volley.toolbox.JsonObjectRequest;

public class MySingleton {
    private static MySingleton instance;

    public static MySingleton getInstance(Main3Activity main3Activity) {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }

    private int x;

    public int incrementX() {
        return ++x;
    }

    public void addToRequestQueue(JsonObjectRequest jsonObjectRequest) {

    }
}