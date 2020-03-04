package cn.com.api;


import cn.com.service.UserService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.*;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;

import java.net.URLDecoder;


@Path
public class UserController {

    @Inject
    private UserService userService;

    @GetRoute("loginCellphone")
    @JSON
    public String loginCellphone(@Param String phone, @Param String password, Response response) {
        try {
            return userService.loginCellphone(phone, password, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("login")
    @JSON
    public String login(@Param String email, @Param String password) {
        try {
            return userService.login(email, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("recommendSongs")
    @JSON
    public String recommendSongs(@CookieParam("WY_TOKEN") String token) {
        try {
            String cookie = URLDecoder.decode(token, "utf-8");
            return userService.recommendSongs(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("recommendResource")
    @JSON
    public String recommendResource(@CookieParam("WY_TOKEN") String token, Request request,Response response) {
        try {
            String cookie = URLDecoder.decode(token, "utf-8");
            return userService.recommendResource(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("userPlayList")
    @JSON
    public String userPlayList(@Param String uid, @Param(defaultValue = "30") Integer limit, @Param(defaultValue = "0") Integer offset) {
        try {
            return userService.userPlayList(uid, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
