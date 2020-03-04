package cn.com.api;

import cn.com.service.PlayListService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;


/**
 * 歌单
 */
@Path
public class PlayListController {

    @Inject
    private PlayListService playListService;


    @GetRoute("personalized")
    @JSON
    public String personalized(@Param( defaultValue = "30") Integer limit, @Param( defaultValue = "0") Integer offset) {
        try {
            return playListService.personalized(limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetRoute("playlist/detail")
    @JSON
    public String playlistDetail(@Param String id, @Param(defaultValue = "8") Integer s) {
        try {
            return playListService.playlistDetail(id, s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetRoute("comment/playlist")
    @JSON
    public String commentPlaylist(
            @Param String id,
            @Param( defaultValue = "20") Integer limit,
            @Param( defaultValue = "0") Integer offset,
            @Param( defaultValue = "0") String before) {
        try {
            return playListService.commentPlaylist(id, limit, offset, before);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetRoute("playlist/catlist")
    @JSON
    public String playlistCatlist() {
        try {
            return playListService.playlistCatlist();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetRoute("top/playlist")
    @JSON
    public String topPlaylist(
            @Param(defaultValue = "hot") String order,
            @Param(defaultValue = "全部") String cat,
            @Param(defaultValue = "50") Integer limit,
            @Param(defaultValue = "0") Integer offset) {
        try {
            return playListService.topPlaylist(order, cat, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
