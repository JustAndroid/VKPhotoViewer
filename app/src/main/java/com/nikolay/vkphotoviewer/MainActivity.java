package com.nikolay.vkphotoviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vk.sdk.VKSdk;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VKSdk.initialize(MainActivity.this);

    }
}
