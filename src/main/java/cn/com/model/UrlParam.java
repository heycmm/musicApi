package cn.com.model;


import cn.com.utils.MusicEncrypt;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;

/**
 * 请求bean
 */
public class UrlParam {

    public String url;

    public JSONObject params;

    public String cookie;

    public String referer;

    public UrlParam() {
        this.params = new JSONObject();
    }

    public UrlParam addParam(String key, Object value) {
        this.params.put(key, value.toString());
        return this;
    }
    public HashMap<String, String> encrypt() throws Exception {
        return   MusicEncrypt.getData(this.params.toJSONString());
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JSONObject getParams() {
        return params;
    }

    public void setParams(JSONObject params) {
        this.params = params;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }
}
