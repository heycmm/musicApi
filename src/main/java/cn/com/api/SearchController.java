package cn.com.api;

import cn.com.service.SearchService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;

/**
 * 搜索模块
 */
@Path
public class SearchController {

    @Inject
    private SearchService searchService;


    @GetRoute("search/suggest")
    @JSON
    public String searchSuggest(@Param String keywords, @Param(defaultValue = "mobile") String type) {
        try {
            return searchService.searchSuggest(keywords, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("search/hot")
    @JSON
    public String searchHot() {
        try {
            return searchService.searchHot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("search/hot/detail")
    @JSON
    public String searchHotDetail() {
        try {
            return searchService.searchHotDetail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetRoute("search")
    public String search(@Param String keywords, @Param(defaultValue = "1") Integer type, @Param(defaultValue = "30") Integer limit, @Param(defaultValue = "0") Integer offset) {
        try {
            return searchService.search(keywords, type, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
