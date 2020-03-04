package cn.com.config;

import com.blade.ioc.annotation.Bean;
import com.blade.mvc.RouteContext;
import com.blade.mvc.hook.WebHook;
import com.blade.mvc.http.Response;
import lombok.extern.slf4j.Slf4j;

/**
 * @author：czx.me 2020/3/4
 */
@Slf4j
@Bean
public class AccessHook implements WebHook {
    @Override
    public boolean before(RouteContext ctx) {
        log.warn("Host =>{},UserAgent =>{},Client Address =>{},origin =>{}，referer =>{}",ctx.header("Host")
                ,ctx.userAgent(),ctx.address(),ctx.header("origin"),ctx.header("referer"));
        return true;
    }
    @Override
    public boolean after(RouteContext context) {
        Response response = context.response();
        response.contentType("text/plain;charset=utf-8");
        response.header("Access-Control-Allow-Origin", "*");
        response.header("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");
        response.header("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, HaiYi-Access-Token");
        return true;
    }
}
