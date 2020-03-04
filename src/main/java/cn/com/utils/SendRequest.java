package cn.com.utils;

import cn.com.model.UrlParam;
import cn.com.utils.MusicEncrypt;
import cn.com.config.UserAgent;
import com.alibaba.fastjson.JSONObject;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.HashMap;
import java.util.Map;

public class SendRequest {

    /**
     * 不需要携带cookie
     *
     * @param up
     * @return
     * @throws Exception
     */
    public static String getMusicData(UrlParam up) throws Exception {
        String url = up.getUrl();
        String params = up.getParams().toJSONString();
        HashMap<String, String> data = MusicEncrypt.getData(params);
        Connection.Response
                response = Jsoup.connect(url)
                //.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:57.0) Gecko/20100101 Firefox/57.0")
                .userAgent(randomUa("mobile"))
                .header("Accept", "*/*")
                .header("Cache-Control", "no-cache")
                .header("Connection", "keep-alive")
                .header("Host", "music.163.com")
                .header("Referer", "https://music.163.com")
                .header("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3")
                .header("DNT", "1")
                .header("Pragma", "no-cache")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .data(data)
                .method(Connection.Method.POST)
                .ignoreContentType(true)
                .timeout(10000)
                .execute();
        String list = response.body();

        Map<String, String> cookies = response.cookies();
        if (cookies.size() > 0) {
            // cookie处理
            JSONObject resultJsonObject = JSONObject.parseObject(list);
            StringBuffer sb = new StringBuffer();
            String remember_me = cookies.get("__remember_me");
            String music_u = cookies.get("MUSIC_U");
            String csrf = cookies.get("__csrf");
            String ntes_nuid = MusicEncrypt.createRandomKey(32);
            sb.append("_ntes_nuid=" + ntes_nuid + ";");
            sb.append("__remember_me=" + remember_me + ";");
            sb.append("MUSIC_U=" + music_u + ";");
            sb.append("__csrf=" + csrf + ";");
            resultJsonObject.put("cookie", sb);
            return resultJsonObject.toString();
        } else {
            return list;
        }
    }

    /**
     * 用户数据访问，需携带cookie
     *
     * @param up
     * @return
     * @throws Exception
     */
    public static String getMusicDataByCookie(UrlParam up) throws Exception {
        String url = up.getUrl();
        String params = up.getParams().toJSONString();
        String cookie = up.getCookie();
        HashMap<String, String> data = MusicEncrypt.getData(params);
        Connection.Response
                response = Jsoup.connect(url)
                //.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:57.0) Gecko/20100101 Firefox/57.0")
                .userAgent(randomUa("mobile"))
                .header("Accept", "*/*")
                .header("Cache-Control", "no-cache")
                .header("Connection", "keep-alive")
                .header("Host", "music.163.com")
                .header("Referer", "https://music.163.com")
                .header("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3")
                .header("DNT", "1")
                .header("Pragma", "no-cache")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .cookie("Cookie", cookie)
                .data(data)
                .method(Connection.Method.POST)
                .ignoreContentType(true)
                .timeout(10000)
                .execute();
        String list = response.body();
        return list;
    }

    public static String randomUa(String ua) {
        int index = 0;
        if (null==ua||ua == "") {
            index = (int) Math.floor(Math.random() * UserAgent.uas.length);
        } else if (ua.equals("mobile")) {
            index = (int) Math.floor(Math.random() * 7);
        } else if (ua.equals("pc")) {
            index = (int) (Math.floor(Math.random() * 5) + 8);
        }else {
            return ua;
        }
        return UserAgent.uas[index];

    }

}
