package cn.com.service;

import cn.com.redis.RedisUtil;
import cn.com.req.Request;
import cn.com.utils.Api;
import cn.com.config.MusicProperties;
import cn.com.model.UrlParam;
import cn.com.utils.Cookie;
import cn.com.utils.Get;
import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;
import java.util.Map;

import static cn.com.common.Constant.COOKIE_KEY;
import static cn.com.req.Utils.MD5_SHA;

@Bean
public class UserService {

    @Inject
    private MusicProperties mp;

    public String loginCellphone(String phone, String password) throws Exception {
        String url = mp.baseUrl + mp.loginCellphone;
        String encryptionPw = MD5_SHA(password,"MD5");
        UrlParam up = Api.loginCellphone(url, phone, encryptionPw);
        Request request = Get.getMusicRequest(up);
        String cookie = request.cookie();
        Map<String, String> map = Cookie.parseStrCookie(cookie);
        if (null!=map&&!map.isEmpty()){
            RedisUtil.del(COOKIE_KEY);
            RedisUtil.set(COOKIE_KEY, map);
        }
        return request.body();
    }

    public String login(String email, String password) throws Exception {
        String url = mp.baseUrl + mp.login;
        String encryptionPw = MD5_SHA(password,"MD5");
        UrlParam up = Api.login(url, email, encryptionPw);
        return Get.getMusicData(up);
    }

    public String recommendSongs(String cookie) throws Exception {
        String url = mp.baseUrl + mp.recommendSongs;
        UrlParam up = Api.recommendSongs(url, cookie);
        return Get.getMusicData(up);
    }

    public String recommendResource(String cookie) throws Exception {
        String url = mp.baseUrl + mp.recommendResource;
        UrlParam up = Api.recommendResource(url, cookie);
        return Get.getMusicData(up);
    }

    public String userPlayList(String uid, Integer limit, Integer offset) throws Exception {
        String url = mp.baseUrl + mp.userPlayList;
        UrlParam up = Api.userPlayList(url, uid, limit, offset);
        return Get.getMusicData(up);
    }


    public String userDetail(String uid) throws Exception{
        String url = mp.baseUrl + mp.userDetail;
        UrlParam up = Api.userDetail(url, uid);
        return Get.getMusicData(up);
    }
}
