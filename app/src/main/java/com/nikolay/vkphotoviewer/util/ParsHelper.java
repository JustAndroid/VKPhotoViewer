package com.nikolay.vkphotoviewer.util;

/**
 * Created by Николай on 01.04.2016.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsHelper {

    String getAccessToken(String uri){
        return parsData(uri, "auth_key\":\"(.*?)\"");
    }

 public static String getId(String uri){
    return parsData(uri, "user_id=(\\d*)");
 }

  private static String parsData(String line, String pattern){
Matcher matcher = Pattern.compile(pattern).matcher(line);
      return matcher.toMatchResult().group(1);
  }

    String[] parsJson(String trt){
        return null;
    }

}
