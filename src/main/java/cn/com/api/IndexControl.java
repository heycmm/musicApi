package cn.com.api;


import cn.com.config.MusicProperties;
import cn.com.service.PlayListService;
import cn.com.service.SongService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PathParam;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Path
public class IndexControl {

    @Inject
    private MusicProperties mp;
    @Inject
    private PlayListService playListService;
    @Inject
    private SongService songService;

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
            collect = this.ListObj(playListService.playlistDetail(id, 8));
            response.json(collect);
        } catch (Exception e) {
            response.text("Not Found.");
        }

    }


    @GetRoute("Lrc/:id")
    public void lrc(@PathParam String id, Response response) {
        try {
            String lyric = "";
            JsonReader reader = Json.createReader(new StringReader(songService.lyric(id)));
            JsonObject root = reader.readObject();
            JsonObject object = root.getJsonObject("lrc");
            if (null != object && object.getValueType() == JsonValue.ValueType.OBJECT) {
                JsonObject lrcJson = object.asJsonObject();
                lyric = lrcJson.getString("lyric");
            }
            if (null == lyric || "".equals(lyric)) {
                lyric = mp.defaultLyric;
            }
            response.text(lyric);
        } catch (Exception e) {
            response.text("Not Found.");
        }
    }

    @GetRoute("Mp3/:id")
    public void mp3(@PathParam String id, Response response) {
        try {
            String url = "";
            JsonReader reader = Json.createReader(new StringReader(songService.songUrl(id, 999000)));
            JsonObject root = reader.readObject();
            url = root
                    .getJsonArray("data")
                    .stream()
                    .map(obj -> {
                        String u = "";
                        if (null != obj && obj.getValueType() == JsonValue.ValueType.OBJECT) {
                            u = obj.asJsonObject().getString("url");
                        }
                        return u;
                    }).collect(Collectors.joining());
            if (null == url || "".equals(url)) {
                response.text("Not Found.");
            } else {
                response.redirect(url);
            }
        } catch (Exception e) {
            response.text("Not Found.");
        }


    }

    public List<Map<String, Object>> ListObj(String up) {
        try {
            JsonReader reader = Json.createReader(new StringReader(up));
            JsonObject root = reader.readObject();
            return root.getJsonObject("playlist")
                    .getJsonArray("tracks")
                    .stream()
                    .map(tr -> {
                        Map<String, Object> map = new HashMap<String, Object>();
                        if (null != tr && tr.getValueType() == JsonValue.ValueType.OBJECT) {
                            JsonObject obj = tr.asJsonObject();
                            String name = obj.getString("name");
                            map.put("name", name);
                            String picUrl = "";
                            String trackId = String.valueOf(obj.get("id"));
                            map.put("url", mp.domain + "/Mp3/" + trackId);
                            map.put("lrc", mp.domain + "/Lrc/" + trackId);
                            JsonObject alObj = obj.getJsonObject("al");
                            picUrl = alObj.getString("picUrl");
                            if (null != picUrl && !"".equals(picUrl)) {
                                picUrl = picUrl.replaceFirst("http", "https");
                            }
                            map.put("cover", picUrl + "?param=300y300");
                            obj.getJsonArray("ar")
                                    .forEach(ar -> {
                                        if (null != ar && ar.getValueType() == JsonValue.ValueType.OBJECT) {
                                            JsonObject arObj = ar.asJsonObject();
                                            String arname = arObj.getString("name");
                                            map.put("artist", arname);
                                        }
                                    });
                        }
                        return map;
                    }).collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
}
