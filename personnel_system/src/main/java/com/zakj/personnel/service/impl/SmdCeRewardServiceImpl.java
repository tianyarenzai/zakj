package com.zakj.personnel.service.impl;

import com.zakj.personnel.dao.SmdCeRewardDao;
import com.zakj.personnel.entity.SmdCeRewardEntity;
import com.zakj.personnel.service.SmdCeRewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 奖惩Service接口
 *
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
@Service("smdCeRewardService")
public class SmdCeRewardServiceImpl implements SmdCeRewardService {
	@Autowired
	private SmdCeRewardDao smdCeRewardDao;
	
	@Override
	public SmdCeRewardEntity queryObject(String rewardId){
		return smdCeRewardDao.queryObject(rewardId);
	}
	
	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> map){
		return smdCeRewardDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return smdCeRewardDao.queryTotal(map);
	}
	
	@Override
	public void save(SmdCeRewardEntity smdCeReward){
		String[] empIds = smdCeReward.getEmployeeId().split(",");
		Map<String, Object> map = new HashMap<String, Object>();
		for(int i = 0; i < empIds.length; i ++) {
			map.put("employeeId", empIds[i]);
			map.put("createDate", smdCeReward.getCreateDate());
			map.put("createEmpName", smdCeReward.getCreateEmpName());
			map.put("createUser", smdCeReward.getCreateUser());
			map.put("rewardContent", smdCeReward.getRewardContent());
			map.put("rewardDate", smdCeReward.getRewardDate());
			map.put("rewardName", smdCeReward.getRewardName());
			map.put("rewardType", smdCeReward.getRewardType());
			map.put("rewardUnit", smdCeReward.getRewardUnit());
			map.put("rewardUrl", smdCeReward.getRewardUrl());
			map.put("state", smdCeReward.getState());
			map.put("rewardAttachment", smdCeReward.getRewardAttachment());
			smdCeRewardDao.saveMap(map);
		}
	}
	
	@Override
	public void update(SmdCeRewardEntity smdCeReward){
		String[] empIds = smdCeReward.getEmployeeId().split(",");
		Map<String, Object> map = new HashMap<String, Object>();
		for(int i = 0; i < empIds.length; i ++) {
			map.put("employee_id", empIds[i]);
			map.put("reward_id", smdCeReward.getRewardId());
			map.put("reward_content", smdCeReward.getRewardContent());
			map.put("reward_date", smdCeReward.getRewardDate());
			map.put("reward_name", smdCeReward.getRewardName());
			map.put("reward_type", smdCeReward.getRewardType());
			map.put("reward_unit", smdCeReward.getRewardUnit());
			map.put("reward_url", smdCeReward.getRewardUrl());
			map.put("reward_attachment", smdCeReward.getRewardAttachment());
			map.put("update_time", smdCeReward.getUpdateTime());
			smdCeRewardDao.updateMap(map);
		}
	}
	
	@Override
	public void delete(String rewardId){
		smdCeRewardDao.delete(rewardId);
	}
	
	@Override
	public void deleteBatch(String[] rewardIds){
		smdCeRewardDao.deleteBatch(rewardIds);
	}
	
}
