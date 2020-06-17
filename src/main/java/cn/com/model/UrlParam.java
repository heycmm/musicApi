package cn.com.model;


import cn.com.utils.MusicEncrypt;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.HashMap;

/**
 * 请求bean
 */
@Data
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
}
