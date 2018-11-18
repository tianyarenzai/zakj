package com.zakj.security.controller;

import com.zakj.utils.PageData;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 类描述： 公共controler 创建人：ssxu 创建时间：2017-6-23 上午9:21:48
 * 
 * @version 1.0
 *
 */
public class BaseController {
    private Map<String, Object> session;// 封装session属性
	public ModelAndView mav = new ModelAndView("");
 
	public PageData getPageData(){
		return new PageData();
	}
	
	/**得到ModelAndView
	 * @return
	 */
	public ModelAndView getModelAndView(){
		return new ModelAndView();
	}
	

	public Map<String, Object> getSession() {
		return session;
	}
 
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	 

	/**
	 * 封装request参数为map
	 * 
	 * @param request
	 * @return
	 */
	public Map<String, Object> getRequestParams(HttpServletRequest request) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, String[]> tmp = request.getParameterMap();
		if (tmp != null) {
			for (String key : tmp.keySet()) {
				String[] values = tmp.get(key);
				returnMap.put(key, values.length == 1 ? values[0].trim() : values);
				if ("pageIndex".equals(key)) {
					String pageIndex = values.length == 1 ? values[0].trim() : values.toString();
					returnMap.put(key, Integer.parseInt(pageIndex));

				} else if ("pageSize".equals(key)) {
					String pageSize = values.length == 1 ? values[0].trim() : values.toString();
					returnMap.put(key, Integer.parseInt(pageSize));

				}
			}
			if (returnMap.containsKey("pageIndex")) {
				returnMap.put("pageIndex", Integer.parseInt(returnMap.get("pageIndex").toString())
						* Integer.parseInt(returnMap.get("pageSize").toString()));

			}
		}

		return returnMap;
	}
}
