package com.nikolay.vkphotoviewer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.methods.VKApiPhotos;
import com.vk.sdk.api.model.VKApiPhoto;
import com.vk.sdk.api.model.VKAttachments;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.api.model.VKWallPostResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import java.util.logging.LogRecord;


public class MainActivity extends AppCompatActivity {

    WebView webView;
TextView textView;
    URL url;
    int length;
    Handler h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
VKSdk.login(this, VKScope.WALL, VKScope.PHOTOS);
h = new Handler();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                textView = (TextView)findViewById(R.id.textView1);
                final ImageView imageView = (ImageView)findViewById(R.id.image1);


                    textView.setText(VKAccessToken.currentToken().accessToken);


                final VKRequest request = new VKRequest("photos.get", VKParameters.from(VKApiConst.ALBUM_ID, "wall"));

request.executeWithListener(new VKRequest.VKRequestListener() {
    @Override
    public void onComplete(VKResponse response) {
        super.onComplete(response);
        JSONArray jsonArray = null;


        try {
            jsonArray = response.json.getJSONObject("response").getJSONArray("items");



        url  = new URL(jsonArray.getJSONObject(1).getString("photo_75"));

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        imageView.setImageBitmap();

    }

    @Override
    public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
        super.attemptFailed(request, attemptNumber, totalAttempts);
    }

    @Override
    public void onError(VKError error) {
        super.onError(error);
        textView.setText(error.toString());
    }
});

            }
            @Override
            public void onError(VKError error) {


            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}
