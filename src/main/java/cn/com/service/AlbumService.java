package cn.com.service;


import cn.com.utils.Api;
import cn.com.utils.SendRequest;
import cn.com.config.MusicProperties;
import cn.com.model.UrlParam;
import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;

@Bean
public class AlbumService {
    @Inject
    private MusicProperties mp;

    public String newAlbum() throws Exception {
        String url = mp.baseUrl + mp.discoveryNewAlbum;
        UrlParam up = Api.album(url);
        return SendRequest.getMusicData(up);
    }
    public String dynamic(String id) throws Exception{
        String url = mp.baseUrl + mp.dynamic;
        UrlParam up = Api.dynamic(url,id);
        return SendRequest.getMusicData(up);
    }

    public String albumSublist(Integer limit, Integer offset) throws Exception{
        String url = mp.baseUrl + mp.albumSublist;
        UrlParam up = Api.albumSublist(url,limit,offset);
        return SendRequest.getMusicDataByCookie(up);
    }
    public String album(String id) throws Exception {
        String url = mp.baseUrl + mp.album + "/" + id;
        UrlParam up = Api.album(url);
        return SendRequest.getMusicData(up);
    }

    public String albumArtists(Integer limit, Integer offset, String id) throws Exception{
        String url = mp.baseUrl + mp.albumArtists + "/" + id;
        UrlParam up = Api.albumArtists(url,limit,offset);
        return SendRequest.getMusicData(up);
    }
}
