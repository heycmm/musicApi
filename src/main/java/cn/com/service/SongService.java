package cn.com.service;


import cn.com.req.Request;
import cn.com.utils.Api;
import cn.com.config.MusicProperties;
import cn.com.model.UrlParam;
import cn.com.utils.Get;
import com.alibaba.fastjson.JSONObject;
import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;

import java.util.HashMap;
import java.util.Map;

@Bean
public class SongService {

    @Inject
    private MusicProperties mp;

    public String songDetail(String ids) throws Exception {
        String url = mp.baseUrl + mp.songDetail;
        UrlParam up = Api.songDetail(url, ids);
        return Get.getMusicData(up);
    }

    public String songUrl(String ids, Integer br) throws Exception {
        String url = mp.baseUrl + mp.songUrl;
        UrlParam up = Api.songUrl(url, ids, br);
        return Get.getMusicData(up);
    }

    public String lyric(String id) throws Exception {
        String url = mp.baseUrl + mp.lyric;
        UrlParam up = Api.lyric(url, id);
        return Get.getMusicData(up);
    }

    public String commentMusic(String id, Integer limit, Integer offset) throws Exception {
        String url = mp.baseUrl + mp.commentMusic + id;
        UrlParam up = Api.commentMusic(url, id, limit, offset);
        return Get.getMusicData(up);
    }

    public String personalizedNewsong() throws Exception {
        String url = mp.baseUrl + mp.personalizedNewsong;
        UrlParam up = Api.personalizedNewsong(url);
        return Get.getMusicData(up);
    }

    public String topSong(Integer type) throws Exception {
        String url = mp.baseUrl + mp.topSong;
        UrlParam up = Api.topSong(url, type);
        return Get.getMusicData(up);
    }

    public String siMiSong(String id, Integer limit, Integer offset) throws Exception {
        String url = mp.baseUrl + mp.siMiSong;
        UrlParam up = Api.discoverySiMiPlaylist(url, id, limit, offset);
        return Get.getMusicData(up);
    }

    public Map<String, Object> player(String type, String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String musicUrl;
            String lrcUrl;
            String cover = "";
            String artist = "";
            String name = "";
            if ("0".equals(type)) {
                musicUrl = mp.domain + "/Mp3/" + id;
                lrcUrl = mp.domain + "/Lrc/" + id;
                String songDetail = this.songDetail(id);
                try {
                    JSONObject songs = JSONObject.parseObject(songDetail).getJSONArray("songs").getJSONObject(0);
                    name = songs.getString("name");
                    cover = songs.getJSONObject("al").getString("picUrl") + "?param=300y300";
                    artist = songs.getJSONArray("ar").getJSONObject(0).getString("name");
                } catch (Exception e) {

                }
            } else {
                String qqSinger = this.getQQSinger(id);
                JSONObject track_info = JSONObject.parseObject(qqSinger)
                        .getJSONObject("songinfo")
                        .getJSONObject("data")
                        .getJSONObject("track_info");
                String albummid = track_info.getJSONObject("album").getString("mid");
                cover = "http://y.gtimg.cn/music/photo_new/T002R300x300M000" + albummid + ".jpg?n=1";
                name = track_info.getString("name");
                artist = track_info.getJSONArray("singer").getJSONObject(0).getString("name");
                musicUrl = mp.domain + "/qqMp3/" + id;
                lrcUrl = mp.domain + "/qqLrc/" + id;
            }

            map.put("url", musicUrl);
            map.put("lrc", lrcUrl);
            map.put("cover", cover);
            map.put("artist", artist);
            map.put("name", name);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    private String getQQSinger(String song_mid) {
        String url = "https://u.y.qq.com/cgi-bin/musicu.fcg?hostUin=0&format=json&inCharset=utf8&outCharset=utf-8&notice=0&platform=yqq.json&needNewCode=0&data={\"comm\":{\"ct\":24,\"cv\":0},\"songinfo\":{\"method\":\"get_song_detail_yqq\",\"param\":{\"song_type\":0,\"song_mid\":\"" + song_mid + "\"},\"module\":\"music.pf_song_detail_svr\"}}";
        return Request.get(url)
                .referer("http://y.qq.com")
                .userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_8; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50")
                .body();
    }

    public String mp3(String id) throws Exception{
      return   JSONObject.parseObject(this.songUrl(id,999000))
                .getJSONArray("data")
                .getJSONObject(0)
                .getString("url");

    }

    public String lrc(String id) throws Exception{
        return JSONObject.parseObject(this.lyric(id))
                .getJSONObject("lrc")
                .getString("lyric");
    }
}
