package com.nikolay.vkphotoviewer.util;

/**
 * Created by Николай on 31.03.2016.
 */
public class Autorize {

    public static final String versionApi = "5.50";
    public static final int clientId = 5385249;
    public static final String redirectUri = "https://oauth.vk.com/blank.html";


    public static String getAuthURL(String scope) {
        return "https://oauth.vk.com/authorize?client_id=" + clientId +
                "&display=page&redirect_uri=" + redirectUri + "&scope=" + scope + "&response_type=token&v=" + versionApi;

    }
}
