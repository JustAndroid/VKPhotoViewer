package com.nikolay.vkphotoviewer.Util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Николай on 26.04.2016.
 */
public class ImageLoader {

  private static   Bitmap bitmap;

    public static Bitmap loadimage(final String url){

new Thread(new Runnable() {
    @Override
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = new URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}).start();



        return bitmap ;
    }

}
