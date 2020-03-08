package cn.com.api;


import cn.com.service.CommonService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.*;
import com.blade.mvc.http.Response;

/**
 * 公共数据
 */
@Path
public class CommonController {

    @Inject
    private CommonService commonService;

    @GetRoute("banner")
    public void banner(@Param(defaultValue = "0") Integer type, Response response) {
        try {
            response.json(commonService.banner(type));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @GetRoute("comment/hot")
    public void commentHot(
            @Param Integer type,
            @Param String id,
            @Param(defaultValue = "20") Integer limit,
            @Param(defaultValue = "0") Integer offset,
            Response response) {
        try {
            response.json(commonService.commentHot(type, id, limit, offset));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
