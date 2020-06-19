package cn.com.webHook;


import com.blade.ioc.annotation.Bean;
import com.blade.mvc.RouteContext;
import com.blade.mvc.hook.WebHook;
import com.blade.mvc.http.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author：czx.me 2020/6/18
 */
@Slf4j
@Bean
public class AccessHook implements WebHook {
    @Override
    public boolean before(RouteContext ctx) {
        log.info("Host =>{},UserAgent =>{},Client Address =>{},origin =>{}，referer =>{}", ctx.header("Host")
                , ctx.userAgent(), ctx.address(), ctx.header("Origin"), ctx.header("referer"));
        String origin = ctx.header("Origin");
        Response response = ctx.response();
        response.contentType("text/plain;charset=utf-8");
        response.header("Access-Control-Allow-Origin", origin);
        response.header("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");
        response.header("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, HaiYi-Access-Token");
        return true;
    }

    @Override
    public boolean after(RouteContext context) {

        return true;
    }
}

