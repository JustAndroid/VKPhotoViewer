package com.nikolay.vkphotoviewer;

import android.content.Intent;
import android.widget.Toast;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;

/**
 * Created by Николай on 30.03.2016.
 */
public class Application extends android.app.Application {

    VKAccessTokenTracker vkAccessTokenTracker = new VKAccessTokenTracker() {
        @Override
        public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
            if (newToken == null) {
                Toast.makeText(Application.this, "AccessToken invalidated", Toast.LENGTH_LONG).show();

            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
       vkAccessTokenTracker.startTracking();
        VKSdk.initialize(this);
    }
    }