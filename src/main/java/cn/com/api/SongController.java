package cn.com.api;

import cn.com.service.SongService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;


/**
 * 音乐模块
 */
@Path
public class SongController {

    @Inject
    private SongService songService;

    @GetRoute("song/detail")
    @JSON
    public String songDetail(@Param String ids) {
        try {
            return songService.songDetail(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("song/url")
    @JSON
    public String songUrl(@Param String id, @Param(defaultValue = "999000") Integer br) {
        try {
            return songService.songUrl(id, br);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("lyric")
    @JSON
    public String lyric(@Param String id) {
        try {
            return songService.lyric(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("comment/music")
    @JSON
    public String commentMusic(@Param String id, @Param(defaultValue = "20") Integer limit, @Param(defaultValue = "0") Integer offset) {
        try {
            return songService.commentMusic(id, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("personalized/newsong")
    @JSON
    public String personalizedNewsong() {
        try {
            return songService.personalizedNewsong();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("top/song")
    @JSON
    public String topSong(@Param(defaultValue = "0") Integer type) {
        try {
            return songService.topSong(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
