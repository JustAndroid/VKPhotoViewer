package com.nikolay.vkphotoviewer;

import android.app.Activity;
import android.os.Bundle;

import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.methods.VKApiPhotos;

/**
 * Created by Николай on 01.04.2016.
 */
public class PhotosActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photos_layout);

        VKRequest vkRequest = VKApi.photos().getUploadServer(6);
    }
}
