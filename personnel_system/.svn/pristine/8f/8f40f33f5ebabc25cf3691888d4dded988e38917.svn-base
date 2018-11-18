package com.zakj.security.dao;

import java.util.List;
import java.util.Map;

/**
 * 基础Dao(还需在XML文件里，有对应的SQL语句)
 * 
 * @author 杨渊
 * @email yangxxil01@sina.com 
 * @date 
 */
public interface BaseDao<T> {
	
	void save(T t);
	
	void save(Map<String, Object> map);
	int saveOrUpdate(Map<String, Object> map);
	
	void saveBatch(List<T> list);
	void saveList(List<Map<String, Object>> list);
	
	int update(T t);
	
	int update(Map<String, Object> map);
	
	int delete(Object id);
	
	int delete(Map<String, Object> map);
	
	int deleteBatch(Object[] id);

	T queryObject(Object id);
	
	List<Map<String, Object>> queryList(Map<String, Object> map);
	
	List<Map<String, Object>> list(Map<String, Object> map);
	
	List<Map<String, Object>> queryBatch(Object[] id);
	
	List<T> queryList(Object id);
	
	int queryTotal(Map<String, Object> map);

	int queryTotal();
}
