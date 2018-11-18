package com.zakj.security.common.beans;

import java.util.List;

/**
 * 集合Ajax响应的封装，一般用于查询列表数据
 * @author wangkl
 * @param <T>
 */
public class AjaxListResult<T> extends AjaxBasicResult {

	private long total;
	private List<T> data;
	private T map;
	private Object[] array;
	private String fileNameStr;
	private String fileTypeStr;
 
	private int code;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	 

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public void setCode(int code) {
		this.code = code;
	}

	public T getMap() {
		return map;
	}

	public void setMap(T map) {
		this.map = map;
	}

	public Object[] getArray() {
		return array;
	}

	public void setArray(Object[] array) {
		this.array = array;
	}

	public String getFileNameStr() {
		return fileNameStr;
	}

	public void setFileNameStr(String fileNameStr) {
		this.fileNameStr = fileNameStr;
	}

	public String getFileTypeStr() {
		return fileTypeStr;
	}

	public void setFileTypeStr(String fileTypeStr) {
		this.fileTypeStr = fileTypeStr;
	}
}
