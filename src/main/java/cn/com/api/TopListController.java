package cn.com.api;

import cn.com.service.TopListService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;


/**
 * 榜单模块
 */
@Path
public class TopListController {

    @Inject
    private TopListService topListService;

    @GetRoute("top/list")
    @JSON
    public String topList(@Param String idx, @Param(defaultValue = "10000") Integer n) {
        try {
            return topListService.topList(idx, n);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("toplist/detail")
    @JSON
    public String toplistDetail() {
        try {
            return topListService.toplistDetail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
