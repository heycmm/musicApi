package cn.com.service;

import cn.com.utils.Api;
import cn.com.config.MusicProperties;
import cn.com.model.UrlParam;
import cn.com.utils.Get;
import com.alibaba.fastjson.JSONObject;
import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;
import com.blade.kit.StringKit;
import com.blade.mvc.http.Response;

import java.net.URLEncoder;
import java.security.MessageDigest;

@Bean
public class UserService {

    @Inject
    private MusicProperties mp;

    public String loginCellphone(String phone, String password, Response response) throws Exception {
        String url = mp.baseUrl + mp.loginCellphone;
        String encryptionPw = this.MD5_SHA(password,"MD5");
        UrlParam up = Api.loginCellphone(url, phone, encryptionPw);
        String musicData = Get.getMusicData(up);
        JSONObject result = JSONObject.parseObject(musicData);
        String cookie = result.getString("cookie");
        if (!StringKit.isBlank(cookie)) {
            String encode = URLEncoder.encode(cookie, "utf-8");
            response.cookie(mp.cookieName,encode);
            result.remove("cookie");
            return result.toString();
        }
        return musicData;
    }

    public String login(String email, String password) throws Exception {
        String url = mp.baseUrl + mp.login;
        String encryptionPw = this.MD5_SHA(password,"MD5");
        UrlParam up = Api.login(url, email, encryptionPw);
        return Get.getMusicData(up);
    }

    public String recommendSongs(String cookie) throws Exception {
        String url = mp.baseUrl + mp.recommendSongs;
        UrlParam up = Api.recommendSongs(url, cookie);
        return Get.getMusicDataByCookie(up);
    }

    public String recommendResource(String cookie) throws Exception {
        String url = mp.baseUrl + mp.recommendResource;
        UrlParam up = Api.recommendResource(url, cookie);
        return Get.getMusicDataByCookie(up);
    }

    public String userPlayList(String uid, Integer limit, Integer offset) throws Exception {
        String url = mp.baseUrl + mp.userPlayList;
        UrlParam up = Api.userPlayList(url, uid, limit, offset);
        return Get.getMusicData(up);
    }
    public final static String MD5_SHA(String s, String method) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance(method);
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    public String userDetail(String uid) throws Exception{
        String url = mp.baseUrl + mp.userDetail;
        UrlParam up = Api.userDetail(url, uid);
        return Get.getMusicData(up);
    }
}
