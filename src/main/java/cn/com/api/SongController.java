package cn.com.api;

import cn.com.service.SongService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Response;


/**
 * 音乐模块
 */
@Path
public class SongController {

    @Inject
    private SongService songService;

    @GetRoute("song/detail")
    public void songDetail(@Param String ids, Response response) {
        try {
            response.json(songService.songDetail(ids));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("song/url")
    public void songUrl(@Param String id, @Param(defaultValue = "999000") Integer br, Response response) {
        try {
            response.json(songService.songUrl(id, br));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("lyric")
    public void lyric(@Param String id, Response respons) {
        try {
            respons.json(songService.lyric(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("comment/music")
    public void commentMusic(@Param String id, @Param(defaultValue = "20") Integer limit, @Param(defaultValue = "0") Integer offset, Response respons) {
        try {
            respons.json(songService.commentMusic(id, limit, offset));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("personalized/newsong")
    public void personalizedNewsong(Response respons) {
        try {
            respons.json(songService.personalizedNewsong());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("top/song")
    public void topSong(@Param(defaultValue = "0") Integer type, Response respons) {
        try {
            respons.json(songService.topSong(type));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
