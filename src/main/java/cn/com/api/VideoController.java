package cn.com.api;

import cn.com.service.VideoService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;

/**
 * 视频模块（0-MV、1-用户上传视频）
 */
@Path
public class VideoController {

    @Inject
    private VideoService videoService;


    @GetRoute("mv/detail")
    @JSON
    public String mvDetail(@Param String mvid) {
        try {
            return videoService.mvDetail(mvid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("video/detail")
    @JSON
    public String videoDetail(@Param String id) {
        try {
            return videoService.videoDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("mv/url")
    @JSON
    public String mvUrl(@Param String id) {
        try {
            return videoService.mvUrl(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("video/url")
    @JSON
    public String videoUrl(@Param String id) {
        try {
            return videoService.videoUrl(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("related/allvideo")
    @JSON
    public String relatedAllvideo(@Param String id) {
        try {
            return videoService.relatedAllvideo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("comment/mv")
    @JSON
    public String commentMv(@Param String id, @Param(defaultValue = "20") Integer limit, @Param(defaultValue = "0") Integer offset) {
        try {
            return videoService.commentMv(id, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("comment/video")
    @JSON
    public String commentVideo(@Param String id, @Param(defaultValue = "20") Integer limit, @Param(defaultValue = "0") Integer offset) {
        try {
            return videoService.commentVideo(id, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
