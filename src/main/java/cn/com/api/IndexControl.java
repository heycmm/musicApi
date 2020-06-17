package cn.com.api;


import cn.com.config.MusicProperties;
import cn.com.service.PlayListService;
import cn.com.service.SongService;
import com.alibaba.fastjson.JSONObject;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PathParam;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import java.util.List;
import java.util.Map;


@Path
public class IndexControl {

    @Inject
    private MusicProperties mp;
    @Inject
    private SongService songService;
    @Inject
    private PlayListService playListService;

    @GetRoute
    public String index(Request request) {
        request.attribute("domain", mp.domain);
        return "music.html";
    }

    @GetRoute("start")
    public String start(Request request) {
        request.attribute("domain", mp.domain);
        return "index.html";
    }

    @GetRoute("List/:id")
    public void list(@PathParam String id, Response response) {
        try {
            List<Map<String, Object>> collect = null;
            collect = playListService.list(id);
            response.json(collect);
        } catch (Exception e) {
            e.printStackTrace();
            response.text("Not Found.");
        }

    }

    /**
     * demo
       <iframe frameborder="no" border="0" marginwidth="0"
       marginheight="0" border="0" scrolling="no"
       allowtransparency="yes" width=100%
       height=102 src="//localhost:8097/player?id=1407551413">
       </iframe>
     *
     * @param type
     * @param id
     * @param request
     * @return
     */
    @GetRoute("player")
    public String player(@Param(defaultValue = "0") String type,
                         @Param(defaultValue = "0") String id,
                         Request request) {
        Map<String, Object> map = songService.player(type, id);
        request.attribute("music", JSONObject.toJSONString(map));
        return "player.html";
    }

    @GetRoute("Mp3/:id")
    public void mp3(@PathParam String id, Response response) {
        try {
            String url = songService.mp3(id);
            if (null == url || "".equals(url)) {
                response.text("Not Found.");
            } else {
                response.redirect(url);
            }
        } catch (Exception e) {
            response.text("Not Found.");
        }
    }

    @GetRoute("Lrc/:id")
    public void lrc(@PathParam String id, Response response) {
        try {
            String lyric = songService.lrc(id);
            if (null == lyric || "".equals(lyric)) {
                lyric = mp.defaultLyric;
            }
            response.text(lyric);

        } catch (Exception e) {
            response.text("Not Found.");
        }
    }
}
