package com.example.project3;

import android.app.Application;
import android.content.Context;

public class MyChat extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
