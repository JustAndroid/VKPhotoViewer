package com.nikolay.vkphotoviewer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.nikolay.vkphotoviewer.util.Autorize;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.model.VKApiPhoto;
import com.vk.sdk.api.model.VKList;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.util.VKUtil;

public class MainActivity extends AppCompatActivity {

    WebView webView;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
       // webView = (WebView) findViewById(R.id.autorize_view);
VKSdk.login(this, VKScope.WALL);
    //   webView.loadUrl(Autorize.getAuthURL(VKScope.WALL + "," + VKScope.PHOTOS));
     //  webView.setWebViewClient(new AutorizeWebViewClient());
textView = (TextView)findViewById(R.id.textView1);
        textView.setText(VKAccessToken.currentToken().accessToken);

    }

    class AutorizeWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

if (url.startsWith(Autorize.redirectUri)) {

//VKSdk.customInitialize(MainActivity.this, R.integer.com_vk_sdk_AppId, Autorize.versionApi);



//startActivity(new Intent(MainActivity.this, PhotosActivity.class));
}
        }
    }

    private VKRequest.VKRequestListener mRequestListener = new VKRequest.VKRequestListener() {
        @Override
        public void onComplete(VKResponse response) {
            try {
                VKList<VKApiPhoto> list = (VKList<VKApiPhoto>) response.parsedModel;
                VKApiPhoto photo_0 = list.get(0);
            } catch (Exception e) {
            }
        }

        @Override
        public void onError(VKError error) {
        }

        @Override
        public void onProgress(VKRequest.VKProgressType progressType, long bytesLoaded,
                               long bytesTotal) {
        }

        @Override
        public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
        }
    };
}
