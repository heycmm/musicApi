package cn.com.api;

import cn.com.service.VideoService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Response;

/**
 * 视频模块（0-MV、1-用户上传视频）
 */
@Path
public class VideoController {

    @Inject
    private VideoService videoService;


    @GetRoute("mv/detail")
    public void mvDetail(@Param String mvid, Response response) {
        try {
            response.json(videoService.mvDetail(mvid));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("video/detail")
    public void videoDetail(@Param String id, Response response) {
        try {
            response.json(videoService.videoDetail(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("mv/url")
    public void mvUrl(@Param String id, Response response) {
        try {
            response.json(videoService.mvUrl(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("video/url")
    public void videoUrl(@Param String id, Response response) {
        try {
            response.json(videoService.videoUrl(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("related/allvideo")
    public void relatedAllvideo(@Param String id, Response response) {
        try {
            response.json(videoService.relatedAllvideo(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("comment/mv")
    public void commentMv(@Param String id, @Param(defaultValue = "20") Integer limit, @Param(defaultValue = "0") Integer offset, Response response) {
        try {
            response.json(videoService.commentMv(id, limit, offset));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("comment/video")
    public void commentVideo(@Param String id, @Param(defaultValue = "20") Integer limit, @Param(defaultValue = "0") Integer offset, Response response) {
        try {
            response.json(videoService.commentVideo(id, limit, offset));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
