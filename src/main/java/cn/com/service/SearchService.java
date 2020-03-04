package cn.com.service;


import cn.com.utils.Api;
import cn.com.utils.SendRequest;
import cn.com.config.MusicProperties;
import cn.com.model.UrlParam;
import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;

@Bean
public class SearchService {

    @Inject
    private MusicProperties mp;

    public String searchSuggest(String keywords, String type) throws Exception {
        if (type.equals("mobile")) {
            type = "keyword";
        } else {
            type = "web";
        }
        String url = mp.baseUrl + mp.searchSuggest + type;
        UrlParam up = Api.searchSuggest(url, keywords);
        return SendRequest.getMusicData(up);
    }

    public String searchHot() throws Exception {
        String url = mp.baseUrl + mp.searchHot;
        UrlParam up = Api.searchHot(url);
        return SendRequest.getMusicData(up);
    }

    public String searchHotDetail() throws Exception {
        String url = mp.baseUrl + mp.searchHotDetail;
        UrlParam up = Api.album(url);
        return SendRequest.getMusicData(up);
    }

    public String search(String keywords, Integer type, Integer limit, Integer offset) throws Exception {
        String url = mp.baseUrl + mp.search;
        UrlParam up = Api.search(url, keywords, type, limit, offset);
        return SendRequest.getMusicData(up);
    }
}
