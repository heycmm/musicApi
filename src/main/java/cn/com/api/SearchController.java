package cn.com.api;

import cn.com.service.SearchService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Response;

/**
 * 搜索模块
 */
@Path
public class SearchController {

    @Inject
    private SearchService searchService;


    @GetRoute("search/suggest")
    public void searchSuggest(@Param String keywords, @Param(defaultValue = "mobile") String type, Response response) {
        try {
            response.json(searchService.searchSuggest(keywords, type));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("search/hot")
    public void searchHot(Response response) {
        try {
            response.json(searchService.searchHot());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("search/hot/detail")
    public void searchHotDetail(Response response) {
        try {
            response.json(searchService.searchHotDetail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetRoute("search")
    public void search(@Param String keywords, @Param(defaultValue = "1") Integer type, @Param(defaultValue = "30") Integer limit, @Param(defaultValue = "0") Integer offset, Response response) {
        try {
            response.json(searchService.search(keywords, type, limit, offset));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
