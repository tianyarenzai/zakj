package com.zakj.personnel.service;


import com.zakj.personnel.entity.SmdCeRemindEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 12288 kB
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
public interface SmdCeRemindService {

	/**
	 * 获取提醒对象
	 * @param remindId
	 * @return
	 */
	SmdCeRemindEntity queryObject(String remindId);

	/**
	 * 获取提醒列表信息
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> queryList(Map<String, Object> map);

	/**
	 * 获取提醒列表数量
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * 保存提醒信息
	 * @param smdCeRemind
	 */
	void save(SmdCeRemindEntity smdCeRemind);

	/**
	 * 编辑提醒信息
	 * @param smdCeRemind
	 */
	void update(SmdCeRemindEntity smdCeRemind);

	/**
	 * 删除提醒信息
	 * @param remindId
	 */
	void delete(String remindId);

	/**
	 * 批量删除提醒信息
	 * @param remindIds
	 */
	void deleteBatch(String[] remindIds);
}
