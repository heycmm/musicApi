package cn.com.service;


import cn.com.utils.Api;
import cn.com.utils.SendRequest;
import cn.com.config.MusicProperties;
import cn.com.model.UrlParam;
import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;

@Bean
public class TopListService {

    @Inject
    private MusicProperties mp;

    public String topList(String id, Integer n) throws Exception {
        String url = mp.baseUrl + mp.topList;
        UrlParam up = Api.topList(url, id, n);
        return SendRequest.getMusicData(up);
    }

    public String toplistDetail() throws Exception {
        String url = mp.baseUrl + mp.toplistDetail;
        UrlParam up = Api.open(url);
        return SendRequest.getMusicData(up);
    }
}
