package cn.com.api;

import cn.com.service.PlayListService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Response;



/**
 * 歌单
 */
@Path
public class PlayListController {

    @Inject
    private PlayListService playListService;


    @GetRoute("personalized")
    public void personalized(@Param(defaultValue = "30") Integer limit, @Param(defaultValue = "0") Integer offset, Response response) {
        try {
            response.json(playListService.personalized(limit, offset));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetRoute("personalized/mv")
    public void personalizedMv( Response response) {
        try {
            response.json(playListService.personalizedMv());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GetRoute("playlist/detail")
    public void playlistDetail(@Param String id, @Param(defaultValue = "8") Integer s, Response response) {
        try {
            response.json(playListService.playlistDetail(id, s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GetRoute("comment/playlist")
    public void commentPlaylist(
            @Param String id,
            @Param(defaultValue = "20") Integer limit,
            @Param(defaultValue = "0") Integer offset,
            @Param(defaultValue = "0") String before, Response response) {
        try {
            response.json(playListService.commentPlaylist(id, limit, offset, before));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GetRoute("playlist/catlist")
    public void playlistCatlist(Response response) {
        try {
            response.json(playListService.playlistCatlist());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GetRoute("top/playlist")
    public void topPlaylist(
            @Param(defaultValue = "hot") String order,
            @Param(defaultValue = "全部") String cat,
            @Param(defaultValue = "50") Integer limit,
            @Param(defaultValue = "0") Integer offset, Response response) {
        try {
            response.json(playListService.topPlaylist(order, cat, limit, offset));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetRoute("top/playlist/highquality")
    public void topPlaylistHighQuality(
            @Param(defaultValue = "全部") String cat,
            @Param(defaultValue = "50") Integer limit,
            @Param(defaultValue = "0") String lasttime, Response response) {
        try {
            response.json(playListService.topPlaylistHighQuality(cat, limit, lasttime));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetRoute("simi/playlist")
    public void discoverySiMiPlaylist(
            @Param String id,
            @Param(defaultValue = "50") Integer limit,
            @Param(defaultValue = "0") Integer offset,
            Response response) {
        try {
            response.json(playListService.discoverySiMiPlaylist(id, limit, offset));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
