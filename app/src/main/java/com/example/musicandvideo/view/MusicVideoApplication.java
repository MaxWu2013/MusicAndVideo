package com.example.musicandvideo.view;

import android.app.Application;

import com.example.musicandvideo.testData.Test;

public class MusicVideoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Test.initTestingData();
    }
}
