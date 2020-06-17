package cn.com.utils;

import cn.com.config.UserAgent;
import cn.com.model.UrlParam;
import cn.com.req.Request;
import java.util.HashMap;


/**
 * @author：czx.me 2020/6/16
 */
public class Get{

    private final static String DEFAULT_UA = "mobile";
    private final static String MUSIC163_REFERER = "https://music.163.com";

    public static String getMusicData(UrlParam up) throws Exception {
        String url = up.getUrl();
        HashMap<String, String> data = up.encrypt();
        return Request.post(url)
                .userAgent(UserAgent.randomUa(DEFAULT_UA))
                .referer(MUSIC163_REFERER)
                .connectTimeout(10000)
                .readTimeout(10000)
                .form(data)
                .body();
    }



    public static String getMusicDataByCookie(UrlParam up) throws Exception {
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


}
