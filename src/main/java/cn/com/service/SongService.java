package cn.com.service;


import cn.com.utils.Api;
import cn.com.utils.SendRequest;
import cn.com.config.MusicProperties;
import cn.com.model.UrlParam;
import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;

@Bean
public class SongService {

    @Inject
    private MusicProperties mp;

    public String songDetail(String ids) throws Exception {
        String url = mp.baseUrl + mp.songDetail;
        UrlParam up = Api.songDetail(url, ids);
        return SendRequest.getMusicData(up);
    }

    public String songUrl(String ids, Integer br) throws Exception {
        String url = mp.baseUrl + mp.songUrl;
        UrlParam up = Api.songUrl(url, ids, br);
        return SendRequest.getMusicData(up);
    }

    public String lyric(String id) throws Exception {
        String url = mp.baseUrl + mp.lyric;
        UrlParam up = Api.lyric(url, id);
        return SendRequest.getMusicData(up);
    }

    public String commentMusic(String id, Integer limit, Integer offset) throws Exception {
        String url = mp.baseUrl + mp.commentMusic + id;
        UrlParam up = Api.commentMusic(url, id, limit, offset);
        return SendRequest.getMusicData(up);
    }

    public String personalizedNewsong() throws Exception {
        String url = mp.baseUrl + mp.personalizedNewsong;
        UrlParam up = Api.personalizedNewsong(url);
        return SendRequest.getMusicData(up);
    }

    public String topSong(Integer type) throws Exception {
        String url = mp.baseUrl + mp.topSong;
        UrlParam up = Api.topSong(url, type);
        return SendRequest.getMusicData(up);
    }

    public String siMiSong(String id, Integer limit, Integer offset)throws Exception {
        String url = mp.baseUrl + mp.siMiSong;
        UrlParam up = Api.discoverySiMiPlaylist(url,id ,limit,offset);
        return SendRequest.getMusicData(up);
    }
}
