package com.zakj.security.common.beans;

import java.util.Map;

public class AjaxLoginResult<T> extends AjaxBaseResult{

	private Map<String, Object> data;
 

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	 

}
