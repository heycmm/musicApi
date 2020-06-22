package cn.com.api;


import cn.com.redis.RedisUtil;
import cn.com.service.UserService;
import cn.com.utils.Cookie;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.*;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;

import java.net.URLDecoder;
import java.util.Map;

import static cn.com.common.Constant.COOKIE_KEY;


@Path
public class UserController {

    @Inject
    private UserService userService;

    @GetRoute("loginCellphone")
    public void loginCellphone(@Param String phone, @Param String password, Response response) {
        try {
            response.json(userService.loginCellphone(phone, password));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("login")
    public void login(@Param String email, @Param String password,Response response) {
        try {
            response.json(userService.login(email, password));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("recommendSongs")
    public void recommendSongs(Response response) {
        try {
            Map<String, String> stringStringMap = RedisUtil.get(COOKIE_KEY);
            response.json(userService.recommendSongs(Cookie.parseMapStr(stringStringMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("recommendResource")
    public void recommendResource(Response response) {
        try {
            Map<String, String> stringStringMap = RedisUtil.get(COOKIE_KEY);
            response.json(userService.recommendResource(Cookie.parseMapStr(stringStringMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("user/playlist")
    public void userPlayList(@Param String uid, @Param(defaultValue = "30") Integer limit, @Param(defaultValue = "0") Integer offset,Response response) {
        try {
            response.json(userService.userPlayList(uid, limit, offset));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetRoute("user/detail")
    public void mvDetail(@Param String uid, Response response) {
        try {
            response.json(userService.userDetail(uid));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
