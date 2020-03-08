package cn.com.config;

import com.blade.ioc.annotation.Bean;
import com.blade.mvc.RouteContext;
import com.blade.mvc.hook.WebHook;
import com.blade.mvc.http.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author：czx.me 2020/3/4
 */
@Slf4j
@Bean
public class AccessHook implements WebHook {
    public static final String[] ALLOW_DOMAIN = {
            "http://localhost:8097",
            "http://localhost:8888",
            "http://127.0.0.1:8097",
            "http://127.0.0.1:8088"
    };
    @Override
    public boolean before(RouteContext ctx) {
        log.info("Host =>{},UserAgent =>{},Client Address =>{},origin =>{}，referer =>{}", ctx.header("Host")
                , ctx.userAgent(), ctx.address(), ctx.header("Origin"), ctx.header("referer"));
        String origin = ctx.header("Origin");
        if (Arrays.asList(ALLOW_DOMAIN).contains(origin)) {
            Response response = ctx.response();
            response.contentType("text/plain;charset=utf-8");
            response.header("Access-Control-Allow-Origin", origin);
            response.header("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");
            response.header("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, HaiYi-Access-Token");
        }
        return true;
    }

    @Override
    public boolean after(RouteContext context) {

        return true;
    }
}
