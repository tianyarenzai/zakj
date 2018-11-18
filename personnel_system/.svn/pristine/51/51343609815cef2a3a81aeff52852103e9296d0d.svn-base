package com.zakj.utils;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-14 23:15
 */
public class Query extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	/**
	 * 当前页码
	 */
    private int page;
    /**
     * 每页条数
     */
    private int limit;

    public Query(Map<String, Object> params){
        this.putAll(params);

        //分页参数    {pageIndex=0, pageSize=20, sortField=, sortOrder=asc}
        this.page = Integer.parseInt(params.get("pageIndex").toString());
        this.limit = Integer.parseInt(params.get("pageSize").toString());
      /**
       *  
       * 分页参数  "pageIndex", (page - 1) * limit;
       */
        this.put("pageIndex", (page ) * limit);
        this.put("page", page);
        this.put("pageSize", limit);
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
