package cn.com.api;


import cn.com.service.AlbumService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
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
}
