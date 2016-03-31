package com.nikolay.vkphotoviewer;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.nikolay.vkphotoviewer.util.Autorize;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.util.VKUtil;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.autorize_view);

       webView.loadUrl(Autorize.getAuthURL(VKScope.WALL + "," + VKScope.PHOTOS));
       webView.setWebViewClient(new AutorizeWebViewClient());
    }

    class AutorizeWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
if( VKAccessToken.tokenFromUrlString(url)!= null) {
    System.out.println();
}
        }
    }
}
