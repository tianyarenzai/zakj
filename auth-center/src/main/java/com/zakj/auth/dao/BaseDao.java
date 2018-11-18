package com.zakj.auth.dao;

import java.util.List;
import java.util.Map;

/**
 *  基础Dao(还需在XML文件里，有对应的SQL语句)
 * Created by 0ops on 2018/5/19.
 */
public interface BaseDao<T>  {
    /**
     * 保存
     *
     * @Title: save
     *
     * @Description: TODO
     *
     * @param: @param t 对象
     *
     * @return: void
     *
     * @throws
     */
    void save(T t);
    /**
     * 	保存
     *
     * @Title: saveMap
     *
     * @Description: TODO
     *
     * @param: @param map Map
     *
     * @return: void
     *
     * @throws
     */
    void saveMap(Map<String, Object> map);
    /**
     * 	保存或更新
     *
     * @Title: saveOrUpdate
     *
     * @Description: TODO
     *
     * @param: @param map
     * @param: @return
     *
     * @return: int
     *
     * @throws
     */
    int saveOrUpdate(Map<String, Object> map);
    /**
     * 	保存多个
     *
     * @Title: saveBatch
     *
     * @Description: TODO
     *
     * @param: @param list
     *
     * @return: void
     *
     * @throws
     */
    void saveBatch(List<T> list);
    /**
     * 保存多个
     *
     * @Title: saveList
     *
     * @Description: TODO
     *
     * @param: @param list
     *
     * @return: void
     *
     * @throws
     */
    void saveList(List<Map<String, Object>> list);
    /**
     * 更新
     *
     * @Title: update
     *
     * @Description: TODO
     *
     * @param: @param t
     * @param: @return
     *
     * @return: int
     *
     * @throws
     */
    int update(T t);
    /**
     * 	更新
     *
     * @Title: updateMap
     *
     * @Description: TODO
     *
     * @param: @param map
     * @param: @return
     *
     * @return: int
     *
     * @throws
     */
    int updateMap(Map<String, Object> map);
    /**
     * 	删除
     *
     * @Title: delete
     *
     * @Description: TODO
     *
     * @param: @param id
     * @param: @return
     *
     * @return: int
     *
     * @throws
     */
    int delete(Object id);
    /**
     * 删除
     *
     * @Title: delete
     *
     * @Description: TODO
     *
     * @param: @param map
     * @param: @return
     *
     * @return: int
     *
     * @throws
     */
    int delete(Map<String, Object> map);
    /**
     * 	删除多个
     *
     * @Title: deleteBatch
     *
     * @Description: TODO
     *
     * @param: @param id
     * @param: @return
     *
     * @return: int
     *
     * @throws
     */
    int deleteBatch(Object[] id);
    /**
     * 查询单个
     *
     * @Title: queryObject
     *
     * @Description: TODO
     *
     * @param: @param id
     * @param: @return
     *
     * @return: T
     *
     * @throws
     */
    T queryObject(Object id);
    /**
     * 查询多个
     *
     * @Title: queryList
     *
     * @Description: TODO
     *
     * @param: @param map
     * @param: @return
     *
     * @return: List<Map<String,Object>>
     *
     * @throws
     */
    List<Map<String, Object>> queryList(Map<String, Object> map);
    /**
     * 插寻多个
     *
     * @Title: list
     *
     * @Description: TODO
     *
     * @param: @param map
     * @param: @return
     *
     * @return: List<Map<String,Object>>
     *
     * @throws
     */
    List<Map<String, Object>> list(Map<String, Object> map);
    /**
     * 	查询
     *
     * @Title: queryBatch
     *
     * @Description: TODO
     *
     * @param: @param id
     * @param: @return
     *
     * @return: List<Map<String,Object>>
     *
     * @throws
     */
    List<Map<String, Object>> queryBatch(Object[] id);
    /**
     * 	查询
     *
     * @Title: queryList
     *
     * @Description: TODO
     *
     * @param: @param id
     * @param: @return
     *
     * @return: List<T>
     *
     * @throws
     */
    List<T> queryList(Object id);
    /**
     * 总记录
     *
     * @Title: queryTotal
     *
     * @Description: TODO
     *
     * @param: @param map
     * @param: @return
     *
     * @return: long
     *
     * @throws
     */
    int queryTotal(Map<String, Object> map);
    /**
     * 总记录
     *
     * @Title: queryTotal
     *
     * @Description: TODO
     *
     * @param: @return
     *
     * @return: long
     *
     * @throws
     */
    long queryTotal();
}
