package cn.com.api;

import cn.com.redis.RedisUtil;
import cn.com.utils.Cookie;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PostRoute;

import java.util.Map;

import static cn.com.common.Constant.COOKIE_KEY;
import static cn.com.common.Constant.QQ_COOKIE_KEY;

/**
 * 临时储存cookie
 *
 * @author：czx.me 2020/6/11
 */
@Path
public class CookieController {

    @PostRoute("/qq/saveCookie")
    public void qqSaveCookie(@Param String strCookie) {
        Map<String, String> map = Cookie.parseStrCookie(strCookie);
        assert map != null;
        String uin = map.get("uin");
        if (!"".equals(uin)) {
            if (!map.isEmpty()) {
                RedisUtil.del(QQ_COOKIE_KEY);
                RedisUtil.set(QQ_COOKIE_KEY, map);
            }
        }
    }

    @PostRoute("/netease/saveCookie")
    public void saveNeteaseCookie(@Param String strCookie) {
        Map<String, String> map = Cookie.parseStrCookie(strCookie);
        if (map != null && !map.isEmpty()) {
            RedisUtil.del(COOKIE_KEY);
            RedisUtil.set(COOKIE_KEY, map);
        }

    }
}
