package cn.com.api;


import cn.com.service.CommonService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.*;

/**
 * 公共数据
 */
@Path
public class CommonController {

    @Inject
    private CommonService commonService;

    @GetRoute("banner")
    @JSON
    public String banner(@Param(defaultValue = "0") Integer type) {
        try {
            return commonService.banner(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("album")
    @JSON
    public String album(@Param String id) {
        try {
            return commonService.album(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostRoute("commentHot")
    @JSON
    public String commentHot(
            @Param Integer type,
            @Param String id,
            @Param( defaultValue = "20") Integer limit,
            @Param( defaultValue = "0") Integer offset) {
        try {
            return commonService.commentHot(type, id, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
