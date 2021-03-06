package cn.com.webHook;


import com.blade.mvc.RouteContext;
import com.blade.mvc.hook.WebHook;
import com.blade.mvc.http.Response;



/**
 * @author：czx.me 2020/6/18
 */
public class AccessHook implements WebHook {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AccessHook.class);
    @Override
    public boolean before(RouteContext ctx) {
        log.info("Host =>{},UserAgent =>{},Client Address =>{},origin =>{}，referer =>{}", ctx.header("Host")
                , ctx.userAgent(), ctx.address(), ctx.header("Origin"), ctx.header("referer"));
        String origin = ctx.header("Origin");
        Response response = ctx.response();
        response.contentType("text/plain;charset=utf-8");
        response.header("Access-Control-Allow-Origin", origin);
        response.header("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");
        response.header("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header");
        return true;
    }

}

