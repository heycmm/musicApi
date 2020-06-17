package cn.com.service;


import cn.com.utils.Api;
import cn.com.config.MusicProperties;
import cn.com.model.UrlParam;
import cn.com.utils.Get;
import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;

@Bean
public class TopListService {

    @Inject
    private MusicProperties mp;

    public String topList(String id, Integer n) throws Exception {
        String url = mp.baseUrl + mp.topList;
        UrlParam up = Api.topList(url, id, n);
        return Get.getMusicData(up);
    }

    public String toplistDetail() throws Exception {
        String url = mp.baseUrl + mp.toplistDetail;
        UrlParam up = Api.open(url);
        return Get.getMusicData(up);
    }
}
