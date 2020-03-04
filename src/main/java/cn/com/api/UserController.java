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
    public void loginCellphone(@Param String phone, @Param String password, Response response) {
        try {
            response.json(userService.loginCellphone(phone, password, response));
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
    public void recommendSongs(@CookieParam("WY_TOKEN") String token,Response response) {
        try {
            String cookie = URLDecoder.decode(token, "utf-8");
            response.json(userService.recommendSongs(cookie));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("recommendResource")
    public void recommendResource(@CookieParam("WY_TOKEN") String token, Request request,Response response) {
        try {
            String cookie = URLDecoder.decode(token, "utf-8");
            response.json(userService.recommendResource(cookie));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("userPlayList")
    public void userPlayList(@Param String uid, @Param(defaultValue = "30") Integer limit, @Param(defaultValue = "0") Integer offset,Response response) {
        try {
            response.json(userService.userPlayList(uid, limit, offset));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
