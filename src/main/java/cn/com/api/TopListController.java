package cn.com.api;

import cn.com.service.TopListService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Response;


/**
 * 榜单模块
 */
@Path
public class TopListController {

    @Inject
    private TopListService topListService;

    @GetRoute("top/list")
    public void topList(@Param String idx, @Param(defaultValue = "10000") Integer n, Response response) {
        try {
            response.json(topListService.topList(idx, n));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("toplist/detail")
    public void toplistDetail(Response response) {
        try {
            response.json(topListService.toplistDetail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
