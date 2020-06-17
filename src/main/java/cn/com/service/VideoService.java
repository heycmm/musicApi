package cn.com.service;


import cn.com.utils.Api;
import cn.com.config.MusicProperties;
import cn.com.model.UrlParam;
import cn.com.utils.Get;
import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;

@Bean
public class VideoService {

    @Inject
    private MusicProperties mp;

    public String mvDetail(String mvid) throws Exception {
        String url = mp.baseUrl + mp.mvDetail;
        UrlParam up = Api.mvDetail(url, mvid);
        return Get.getMusicData(up);
    }

    public String videoDetail(String id) throws Exception {
        String url = mp.baseUrl + mp.videoDetail;
        UrlParam up = Api.mvDetail(url, id);
        return Get.getMusicData(up);
    }

    public String mvUrl(String id) throws Exception {
        String url = mp.baseUrl + mp.mvUrl;
        UrlParam up = Api.mvUrl(url, id);
        return Get.getMusicData(up);
    }

    public String videoUrl(String id) throws Exception {
        String url = mp.baseUrl + mp.videoUrl;
        UrlParam up = Api.videoUrl(url, id);
        return Get.getMusicData(up);
    }

    public String relatedAllvideo(String id) throws Exception {
        String url = mp.baseUrl + mp.relatedAllvideo;
        UrlParam up = Api.relatedAllvideo(url, id);
        return Get.getMusicData(up);
    }

    public String commentMv(String id, Integer limit, Integer offset) throws Exception {
        String url = mp.baseUrl + mp.commentMv + id;
        UrlParam up = Api.commentMv(url, id, limit, offset);
        return Get.getMusicData(up);
    }

    public String commentVideo(String id, Integer limit, Integer offset) throws Exception {
        String url = mp.baseUrl + mp.commentVideo + id;
        UrlParam up = Api.commentMv(url, id, limit, offset);
        return Get.getMusicData(up);
    }


    public String mvAll(String area, String order, String type, Integer limit, Integer offset) throws Exception{
        String url = mp.mvAll;
        UrlParam up = Api.mvAll(url,area,order,type, limit, offset);
        return Get.getMusicData(up);
    }

    public String siMiMv(String mvid) throws Exception{
        String url = mp.baseUrl + mp.siMiMv;
        UrlParam up = Api.siMiMv(url, mvid);
        return Get.getMusicData(up);
    }
}
