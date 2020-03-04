package cn.com.service;


import cn.com.utils.Api;
import cn.com.utils.SendRequest;
import cn.com.config.MusicProperties;
import cn.com.model.UrlParam;
import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;

@Bean
public class PlayListService {

    @Inject
    private MusicProperties mp;

    public String personalized(Integer limit, Integer offset) throws Exception {
        String url = mp.baseUrl + mp.personalizedPlayList;
        UrlParam up = Api.personalized(url, limit, offset);
        return SendRequest.getMusicData(up);
    }

    public String playlistDetail(String id, Integer s) throws Exception {
        String url = mp.baseUrl + mp.playlistDetail;
        UrlParam up = Api.playlistDetail(url, id, s);
        return SendRequest.getMusicData(up);
    }

    public String commentPlaylist(String id, Integer limit, Integer offset, String before) throws Exception {
        String url = mp.baseUrl + mp.commentPlayList + id;
        UrlParam up = Api.commentPlaylist(url, id, limit, offset, before);
        return SendRequest.getMusicData(up);
    }

    public String playlistCatlist() throws Exception {
        String url = mp.baseUrl + mp.playlistCatlist;
        UrlParam up = Api.open(url);
        return SendRequest.getMusicData(up);
    }

    public String topPlaylist(String order, String cat, Integer limit, Integer offset) throws Exception {
        String url = mp.baseUrl + mp.topPlaylist;
        UrlParam up = Api.topPlaylist(url, order, cat, limit, offset);
        return SendRequest.getMusicData(up);
    }
}
