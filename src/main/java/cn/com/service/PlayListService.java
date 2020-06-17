package cn.com.service;


import cn.com.utils.Api;
import cn.com.utils.Get;
import cn.com.config.MusicProperties;
import cn.com.model.UrlParam;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;

import java.util.*;


@Bean
public class PlayListService {

    @Inject
    private MusicProperties mp;
    @Inject
    private SongService songService;

    public String personalized(Integer limit, Integer offset) throws Exception {
        String url = mp.baseUrl + mp.personalizedPlayList;
        UrlParam up = Api.personalized(url, limit, offset);
        return Get.getMusicData(up);
    }

    public String playlistDetail(String id, Integer s) throws Exception {
        String url = mp.baseUrl + mp.playlistDetail;
        UrlParam up = Api.playlistDetail(url, id, s);
        return Get.getMusicData(up);
    }

    public String commentPlaylist(String id, Integer limit, Integer offset, String before) throws Exception {
        String url = mp.baseUrl + mp.commentPlayList + id;
        UrlParam up = Api.commentPlaylist(url, id, limit, offset, before);
        return Get.getMusicData(up);
    }

    public String playlistCatlist() throws Exception {
        String url = mp.baseUrl + mp.playlistCatlist;
        UrlParam up = Api.open(url);
        return Get.getMusicData(up);
    }

    public String topPlaylist(String order, String cat, Integer limit, Integer offset) throws Exception {
        String url = mp.baseUrl + mp.topPlaylist;
        UrlParam up = Api.topPlaylist(url, order, cat, limit, offset);
        return Get.getMusicData(up);
    }

    public String personalizedMv() throws Exception {
        String url = mp.baseUrl + mp.personalizedMv;
        UrlParam up = Api.open(url);
        return Get.getMusicData(up);
    }

    public String discoverySiMiPlaylist(String id, Integer limit, Integer offset) throws Exception {
        String url = mp.baseUrl + mp.discoverySiMiPlaylist;
        UrlParam up = Api.discoverySiMiPlaylist(url, id, limit, offset);
        return Get.getMusicData(up);
    }

    public String topPlaylistHighQuality(String cat, Integer limit, String lasttime) throws Exception {
        String url = mp.baseUrl + mp.topPlaylistHighQuality;
        UrlParam up = Api.topPlaylistHighQuality(url, cat, limit, lasttime);
        return Get.getMusicData(up);
    }

    public List<Map<String, Object>> list(String id) throws Exception {
        StringBuilder sb = new StringBuilder();
        JSONArray jsonArray = JSONObject.parseObject(this.playlistDetail(id, 8))
                .getJSONObject("playlist")
                .getJSONArray("trackIds");
        for (int i = 0; i < jsonArray.size(); i++) {
            sb.append(jsonArray.getJSONObject(i).getString("id")).append(",");
        }
        String songStr = songService.songDetail(sb.toString());
        List<Map<String, Object>> list = new ArrayList<>();
        JSONArray songsArray = JSONObject.parseObject(songStr).getJSONArray("songs");
        for (int i = 0; i < songsArray.size(); i++) {
            Map<String, Object> map = new HashMap<>();
            JSONObject song = songsArray.getJSONObject(i);
            String songId = song.getString("id");
            String name = song.getString("name");
            String artist = song.getJSONArray("ar").getJSONObject(0).getString("name");
            String cover = song.getJSONObject("al").getString("picUrl");
            map.put("url", mp.domain + "/Mp3/" + songId);
            map.put("lrc", mp.domain + "/Lrc/" + songId);
            map.put("cover", cover + "?param=300y300");
            map.put("name", name);
            map.put("artist", artist);
            list.add(map);
        }
        return list;
    }
}
