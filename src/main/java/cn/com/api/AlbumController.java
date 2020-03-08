package cn.com.api;


import cn.com.service.AlbumService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Response;

/**
 * 专辑
 */
@Path
public class AlbumController {

    @Inject
    private AlbumService albumService;

    @GetRoute("album/newest")
    public void newAlbum(Response response) {
        try {
            response.json(albumService.newAlbum());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetRoute("album")
    public void album(@Param String id, Response response) {
        try {
            response.json(albumService.album(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("album/detail/dynamic")
    public void dynamic(@Param String id, Response response) {
        try {
            response.json(albumService.dynamic(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("album/sublist")
    public void albumSublist(@Param(defaultValue = "25") Integer limit,
                             @Param(defaultValue = "0") Integer offset,
                             Response response) {
        try {
            response.json(albumService.albumSublist(limit, offset));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("artists")
    public void albumArtists(@Param(defaultValue = "30") Integer limit,
                             @Param(defaultValue = "0") Integer offset,
                             @Param(defaultValue = "6452") String id,
                             Response response) {
        try {
            response.json(albumService.albumArtists(limit, offset,id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
