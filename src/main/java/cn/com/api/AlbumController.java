package cn.com.api;


import cn.com.service.AlbumService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Path;

/**
 * 专辑
 */
@Path
public class AlbumController {

    @Inject
    private AlbumService albumService;

    @GetRoute("album/newest")
    @JSON
    public String newAlbum() {
        try {
            return albumService.newAlbum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
