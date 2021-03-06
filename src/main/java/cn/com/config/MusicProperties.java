package cn.com.config;

import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Value;

@Bean
public class MusicProperties {

    @Value(name = "cookieName")
    public String cookieName;

    @Value(name = "baseUrl")
    public String baseUrl;

    // banner
    @Value(name = "banner")
    public String banner;

    // 推荐歌单
    @Value(name = "personalizedPlayList")
    public String personalizedPlayList;

    // 最新专辑
    @Value(name = "discoveryNewAlbum")
    public String discoveryNewAlbum;

    // 最新专辑
    @Value(name = "playlistDetail")
    public String playlistDetail;

    // 排行榜
    @Value(name = "topList")
    public String topList;

    // 获取音乐url
    @Value(name = "songUrl")
    public String songUrl;

    // 获取歌词
    @Value(name = "lyric")
    public String lyric;

    // 获取歌曲详情
    @Value(name = "songDetail")
    public String songDetail;

    // 获取专辑内容
    @Value(name = "album")
    public String album;

    // 歌曲评论
    @Value(name = "commentMusic")
    public String commentMusic;

    // 热门评论
    @Value(name = "commentHot")
    public String commentHot;

    // 每日歌曲推荐
    @Value(name = "recommendSongs")
    public String recommendSongs;

    // 用户歌单
    @Value(name = "userPlayList")
    public String userPlayList;

    // 搜索
    @Value(name = "search")
    public String search;

    // 手机号码登录
    @Value(name = "loginCellphone")
    public String loginCellphone;

    // 邮箱登录
    @Value(name = "login")
    public String login;

    // 每日推荐歌单
    @Value(name = "recommendResource")
    public String recommendResource;

    // MV详情
    @Value(name = "mvDetail")
    public String mvDetail;

    // 视频详情
    @Value(name = "videoDetail")
    public String videoDetail;

    // MV链接
    @Value(name = "mvUrl")
    public String mvUrl;

    // 视频链接
    @Value(name = "videoUrl")
    public String videoUrl;

    // 相关视频
    @Value(name = "relatedAllvideo")
    public String relatedAllvideo;

    // MV评论
    @Value(name = "commentMv")
    public String commentMv;

    // 视频评论
    @Value(name = "commentVideo")
    public String commentVideo;

    // 搜索建议
    @Value(name = "searchSuggest")
    public String searchSuggest;

    // 热搜列表(简略)
    @Value(name = "searchHot")
    public String searchHot;

    // 热搜列表(详细)
    @Value(name = "searchHotDetail")
    public String searchHotDetail;

    // 推荐新音乐
    @Value(name = "personalizedNewsong")
    public String personalizedNewsong;

    // 新歌速递
    @Value(name = "topSong")
    public String topSong;

    // 歌单评论
    @Value(name = "commentPlayList")
    public String commentPlayList;

    // 所有榜单内容摘要
    @Value(name = "toplistDetail")
    public String toplistDetail;

    // 全部歌单分类
    @Value(name = "playlistCatlist")
    public String playlistCatlist;

    // 全部歌单分类
    @Value(name = "topPlaylist")
    public String topPlaylist;


    @Value(name = "defaultLyric")
    public String defaultLyric;

    // 配置域名
    @Value(name = "domain")
    public String domain;

    // 专辑动态信息
    @Value(name = "detailDynamic")
    public String dynamic;

    //已收藏专辑列表
    @Value(name = "albumSublist")
    public String albumSublist;

    // 歌手专辑列表
    @Value(name = "albumArtists")
    public String albumArtists;

    // 推荐MV
    @Value(name = "personalizedMv")
    public String personalizedMv;

    // 相似歌单
    @Value(name = "discoverySiMiPlaylist")
    public String discoverySiMiPlaylist;

    // 相似歌曲
    @Value(name = "siMiSong")
    public String siMiSong;

    // 精品歌单
    @Value(name = "topPlaylistHighQuality")
    public String topPlaylistHighQuality;

    // 全部MV
    @Value(name = "mvAll")
    public String mvAll;

    // 相似MV
    @Value(name = "siMiMv")
    public String siMiMv;


    // 用户详情
    @Value(name = "userDetail")
    public String userDetail;


    @Value(name = "qqBaseUrl")
    public String qqBaseUrl;

    //获取歌词
    @Value(name ="fcg_query_lyric_new")
    public String fcg_query_lyric_new;

}