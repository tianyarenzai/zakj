package com.zakj.personnel.service.impl;

import com.zakj.personnel.dao.SmdCeAttachmentDao;
import com.zakj.personnel.entity.SmdCeAttachmentEntity;
import com.zakj.personnel.service.SmdCeAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * 合同附件Service接口
 *
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
@Service("smdCeAttachmentService")
public class SmdCeAttachmentServiceImpl implements SmdCeAttachmentService {
	@Autowired
	private SmdCeAttachmentDao smdCeAttachmentDao;
	
	@Override
	public SmdCeAttachmentEntity queryObject(String attachmentId){
		return smdCeAttachmentDao.queryObject(attachmentId);
	}
	
	@Override
	public List<Map<String,Object>> queryList(Map<String, Object> map){
		return smdCeAttachmentDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return smdCeAttachmentDao.queryTotal(map);
	}
	
	@Override
	public void save(SmdCeAttachmentEntity smdCeAttachment){
		smdCeAttachmentDao.save(smdCeAttachment);
	}
	
	@Override
	public void update(SmdCeAttachmentEntity smdCeAttachment){
		smdCeAttachmentDao.update(smdCeAttachment);
	}
	
	@Override
	public void delete(String attachmentId){
		smdCeAttachmentDao.delete(attachmentId);
	}
	
	@Override
	public void deleteBatch(String[] attachmentIds){
		smdCeAttachmentDao.deleteBatch(attachmentIds);
	}
	
}
