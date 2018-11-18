package com.zakj.personnel.service;

import com.zakj.personnel.entity.SmdCeRewardEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 12288 kB
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-14 17:01:30
 */
public interface SmdCeRewardService {
	/**
	 * 获取奖惩对象
	 * @param rewardId
	 * @return
	 */
	SmdCeRewardEntity queryObject(String rewardId);

	/**
	 * 获取奖惩列表信息
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> queryList(Map<String, Object> map);

	/**
	 * 获取奖惩列表数量
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * 保存奖惩信息
	 * @param smdCeReward
	 */
	void save(SmdCeRewardEntity smdCeReward);

	/**
	 * 编辑奖惩信息
	 * @param smdCeReward
	 */
	void update(SmdCeRewardEntity smdCeReward);

	/**
	 * 删除奖惩信息
	 * @param rewardId
	 */
	void delete(String rewardId);

	/**
	 * 批量删除奖惩信息
	 * @param rewardIds
	 */
	void deleteBatch(String[] rewardIds);
}
