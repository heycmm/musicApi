package cn.com.utils;


import cn.com.model.UrlParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static cn.com.req.Utils.getRandom;

public class Api {
    public static final String FIDDLER_BASE_QQ_URL = "https://c.y.qq.com/";

    public static UrlParam banner(String url, Integer type) {
        String[] typeList = {"pc", "android", "iphone", "ipad"};
        url += "?clientType=" + typeList[type];
        UrlParam up = new UrlParam();
        up.setUrl(url);
//        up.addParam("clientType", typeList[type]);
        return up;
    }

    public static UrlParam personalized(String url, Integer limit, Integer offset) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("limit", limit);
        up.addParam("offset", offset);
        up.addParam("total", true);
        up.addParam("n", 1000);
        return up;
    }

    public static UrlParam playlistDetail(String url, String id, Integer s) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("id", id);
        up.addParam("n", 100000);
        up.addParam("s", s);
        return up;
    }

    public static UrlParam topList(String url, String id, Integer n) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("id", id);
        up.addParam("n", n);
        return up;
    }

    public static UrlParam songUrl(String url, String ids, Integer br) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("ids", "[" + ids + "]");
        up.addParam("br", br);
        return up;
    }

    public static UrlParam lyric(String url, String id) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("id", id);
        up.addParam("lv", -1);
        up.addParam("kv", -1);
        up.addParam("tv", -1);
        return up;
    }

    public static UrlParam songDetail(String url, String ids) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        String[] split = ids.split(",");
        String collect = Arrays.stream(split).map(i -> "{'id':'" + i.toString() + "'}").collect(Collectors.joining(","));
//        up.addParam("c", "[{'id':'1365393542'},{'id':'1369601580'}]");
        up.addParam("c", "[" + collect + "]");
        up.addParam("ids", "[" + ids + "]");
        return up;
    }

    public static UrlParam album(String url) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        return up;
    }

    public static UrlParam commentMusic(String url, String id, Integer limit, Integer offset) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("rid", id);
        up.addParam("limit", limit);
        up.addParam("offset", offset);
        return up;
    }

    public static UrlParam recommendSongs(String url, String cookie) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.setCookie(cookie);
        up.addParam("limit", 20);
        up.addParam("offset", 0);
        up.addParam("total", true);
        return up;
    }

    public static UrlParam userPlayList(String url, String uid, Integer limit, Integer offset) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("uid", uid);
//        up.addParam("total", true);
        up.addParam("limit", limit);
        up.addParam("offset", offset);
//        up.addParam("n", 1000);
        return up;
    }

    public static UrlParam search(String url, String keywords, Integer type, Integer limit, Integer offset) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("s", keywords);
        up.addParam("type", type);
        up.addParam("limit", limit);
        up.addParam("offset", offset);
        return up;
    }

    public static UrlParam loginCellphone(String url, String phone, String password) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("phone", phone);
        up.addParam("password", password);
        up.addParam("rememberLogin", "true");
        return up;
    }

    public static UrlParam login(String url, String email, String password) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("username", email);
        up.addParam("password", password);
        up.addParam("rememberLogin", "true");
        return up;
    }

    public static UrlParam recommendResource(String url, String cookie) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.setCookie(cookie);
        return up;
    }

    public static UrlParam mvDetail(String url, String mvid) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("id", mvid);
        return up;
    }

    public static UrlParam mvUrl(String url, String id) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("id", id);
        up.addParam("r", 1080);
        return up;
    }

    public static UrlParam videoUrl(String url, String id) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("ids", "[\"" + id + "\"]");
        up.addParam("resolution", 1080);
        return up;
    }

    public static UrlParam relatedAllvideo(String url, String id) {
        UrlParam up = new UrlParam();
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        boolean matches = pattern.matcher(id).matches();
        if (matches) {
            up.addParam("type", 0);
        } else {
            up.addParam("type", 1);
        }
        up.setUrl(url);
        up.addParam("id", id);
        return up;
    }

    public static UrlParam commentMv(String url, String id, Integer limit, Integer offset) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("rid", id);
        up.addParam("limit", limit);
        up.addParam("offset", offset);
        up.addParam("beforeTime", 0);
        return up;
    }

    public static UrlParam searchSuggest(String url, String keywords) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("s", keywords);
        return up;
    }

    public static UrlParam searchHot(String url) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("type", 1111);
        return up;
    }

    public static UrlParam personalizedNewsong(String url) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("type", "recommend");
        return up;
    }

    public static UrlParam topSong(String url, Integer type) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("areaId", type);
        up.addParam("total", true);
        return up;
    }

    public static UrlParam commentPlaylist(String url, String id, Integer limit, Integer offset, String before) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("rid", id);
        up.addParam("limit", limit);
        up.addParam("offset", offset);
        up.addParam("beforeTime", before);
        return up;
    }

    public static UrlParam open(String url) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        return up;
    }

    public static UrlParam topPlaylist(String url, String order, String cat, Integer limit, Integer offset) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("cat", cat);
        up.addParam("order", order);
        up.addParam("limit", limit);
        up.addParam("offset", offset);
        up.addParam("total", true);
        return up;
    }

    public static UrlParam albumSublist(String url, Integer limit, Integer offset) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("limit", limit);
        up.addParam("offset", offset);
        up.addParam("total", true);
        return up;
    }

    public static UrlParam albumArtists(String url, Integer limit, Integer offset) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("limit", limit);
        up.addParam("offset", offset);
        up.addParam("total", true);
        return up;
    }

    public static UrlParam dynamic(String url, String id) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("id", id);
        return up;
    }

    public static UrlParam discoverySiMiPlaylist(String url, String id, Integer limit, Integer offset) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("songid", id);
        up.addParam("limit", limit);
        up.addParam("offset", offset);
        return up;
    }

    public static UrlParam topPlaylistHighQuality(String url, String cat, Integer limit, String lasttime) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("cat", cat);
        up.addParam("limit", limit);
        up.addParam("lasttime", lasttime);
        up.addParam("total", true);
        return up;
    }

    public static UrlParam mvAll(String url, String area, String order, String type, Integer limit, Integer offset) {
        UrlParam up = new UrlParam();
        try {
            area = URLEncoder.encode(area, "utf-8");
            order = URLEncoder.encode(order, "utf-8");
            type = URLEncoder.encode(type, "utf-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //url="https://interface.music.163.com/api/mv/all?tags={'地区:'"+area+",'全部','"+type+"','排序':'"+order+"'&offset=0&total=true&limit=40";
        url = "https://interface.music.163.com/api/mv/all?tags={%22%E5%9C%B0%E5%8C%BA%22:%22" + area + "%22,%22%E7%B1%BB%E5%9E%8B%22:%22" + type + "%22,%22%E6%8E%92%E5%BA%8F%22:%22" + order + "%22}&offset=" + offset + "&total=true&limit=" + limit + "";
        up.setUrl(url);

        return up;
    }

    public static UrlParam siMiMv(String url, String mvid) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("mvid", mvid);
        return up;
    }

    public static UrlParam userDetail(String url, String uid) {
        UrlParam up = new UrlParam();
        up.setUrl(url + "/" + uid);
        return up;
    }

    public static UrlParam qqMp3(String songmid, Map<String, String> map) {
        UrlParam up = new UrlParam();
        String uin = map.get("uin");
        if (!map.isEmpty()) {
            String cookies = Cookie.parseMapStr(map);
            up.setCookie(cookies);
        }
        up.setReferer(FIDDLER_BASE_QQ_URL);
        String random = getRandom(9);
        String url = String.format("https://u.y.qq.com/cgi-bin/musicu.fcg?format=json&inCharset=utf8&outCharset=utf-8&notice=0&platform=yqq.json&needNewCode=0&data={\"req\":{\"module\":\"CDN.SrfCdnDispatchServer\",\"method\":\"GetCdnDispatch\",\"param\":{\"guid\":\"%s\",\"calltype\":0,\"userip\":\"\"}},\"req_0\":{\"module\":\"vkey.GetVkeyServer\",\"method\":\"CgiGetVkey\",\"param\":{\"guid\":\"%s\",\"songmid\":[\"%s\"],\"songtype\":[0],\"uin\":\"%s\",\"loginflag\":1,\"platform\":\"20\"}},\"comm\":{\"uin\":%s,\"format\":\"json\",\"ct\":24,\"cv\":0}}", random, random, songmid, uin, uin);
        // String data = String.format("{\"req\":{\"module\":\"CDN.SrfCdnDispatchServer\",\"method\":\"GetCdnDispatch\",\"param\":{\"guid\":\"%s\",\"calltype\":0,\"userip\":\"\"}},\"req_0\":{\"module\":\"vkey.GetVkeyServer\",\"method\":\"CgiGetVkey\",\"param\":{\"guid\":\"%s\",\"songmid\":[\"%s\"],\"songtype\":[0],\"uin\":\"%s\",\"loginflag\":1,\"platform\":\"20\"}},\"comm\":{\"uin\":%s,\"format\":\"json\",\"ct\":24,\"cv\":0}",random,random,songmid,uin,uin);
        up.setUrl(url);
        return up;
    }

    public static UrlParam fcg_query_lyric_new(String url, String songmid) {
        UrlParam up = new UrlParam();
        up.setReferer(FIDDLER_BASE_QQ_URL);
        up.addParam("songmid", songmid);
        up.addParam("pcachetime", new Date().getTime());
        up.addParam("g_tk", "5381");
        up.addParam("loginUin", "0");
        up.addParam("inCharset", "utf8");
        up.addParam("outCharset", "utf-8");
        up.addParam("notice", "0");
        up.addParam("nobase64", "1");
        up.addParam("format", "json");
        up.addParam("platform", "yqq");
        up.addParam("needNewCode", "0");
        up.setUrl(url);
        return up;
    }
}
