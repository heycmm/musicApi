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
}
