package com.zakj.personnel.service;

import com.zakj.personnel.entity.AlyApSevPushMessageEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 9216 kB
 * 
 * @author zhangxia
 * @email zx_hrxt@163.com
 * @date 2018-04-03 15:47:21
 */
public interface AlyApSevPushMessageService {
	
	AlyApSevPushMessageEntity queryObject(Long messageId);
	
	List<Map<String, Object>> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AlyApSevPushMessageEntity alyApSevPushMessage) throws Exception;
	
	void update(AlyApSevPushMessageEntity alyApSevPushMessage);
	
	void delete(Long messageId);
	
	void deleteBatch(Long[] messageIds);
}
