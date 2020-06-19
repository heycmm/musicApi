package cn.com.utils;

import cn.com.config.UserAgent;
import cn.com.model.UrlParam;
import cn.com.req.Request;

import java.util.*;


/**
 * @author：czx.me 2020/6/16
 */
public class Get{

    private final static String DEFAULT_UA = "mobile";
    private final static String MUSIC163_REFERER = "https://music.163.com";

    public static String getMusicData(UrlParam up) throws Exception {
        String url = up.getUrl();
        String cookie = up.getCookie();
        HashMap<String, String> data = up.encrypt();
        return Request.post(url)
                .userAgent(UserAgent.randomUa(DEFAULT_UA))
                .referer(MUSIC163_REFERER)
                .cookie(cookie)
                .connectTimeout(10000)
                .readTimeout(10000)
                .form(data)
                .body();
    }
    // 登陆
    public static Request getMusicRequest(UrlParam up) throws Exception {
        String url = up.getUrl();
        String cookie = up.getCookie();
        HashMap<String, String> data = up.encrypt();
         return Request.post(url)
                .userAgent(UserAgent.randomUa(DEFAULT_UA))
                .referer(MUSIC163_REFERER)
                .cookie(cookie)
                .connectTimeout(10000)
                .readTimeout(10000)
                .form(data);
    }
    public static String getQQMusicApi(UrlParam up) throws Exception{
        String url = up.getUrl();
        String referer = up.getReferer();
        String cookies = up.getCookie();
        return Request.get(url)
                .referer(referer)
                .contentType("application/x-www-form-urlencoded","utf-8")
                .cookie(cookies)
                .body();
    }


}
