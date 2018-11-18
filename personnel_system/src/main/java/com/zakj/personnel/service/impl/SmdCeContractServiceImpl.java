package com.zakj.personnel.service.impl;

import com.zakj.personnel.dao.SmdCeAttachmentDao;
import com.zakj.personnel.dao.SmdCeContractDao;
import com.zakj.personnel.entity.SmdCeAttachmentEntity;
import com.zakj.personnel.entity.SmdCeContractEntity;
import com.zakj.personnel.service.SmdCeContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
/**
 * 合同Service接口
 *
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
@Service("smdCeContractService")
public class SmdCeContractServiceImpl implements SmdCeContractService {
	/**注入合同的DAO */
	@Autowired
	private SmdCeContractDao smdCeContractDao;

	/**注入合同附件的DAO*/
	@Autowired
	private SmdCeAttachmentDao smdCeAttachmentDao;

	
	@Override
	public SmdCeContractEntity queryObject(String contractId){
		return smdCeContractDao.queryObject(contractId);
	}
	
	@Override
	public List<Map<String,Object>> queryList(Map<String, Object> map){
		return smdCeContractDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return smdCeContractDao.queryTotal(map);
	}
	
	@Override
	public void save(SmdCeContractEntity smdCeContract){
		// 1. 保存合同信息
		smdCeContractDao.save(smdCeContract);
		// 2.保存附件信息
		System.out.println("合同Id----------------------------- " + smdCeContract.getContractId());
		System.out.println("附件URLs:  ------------------------- " +  smdCeContract.getContractImgurl());
		System.out.println("附件名: ------------------------------" + smdCeContract.getFileName());
		System.out.println("附件类型: ------------------------------" + smdCeContract.getFileType());
		String[] urls = smdCeContract.getContractImgurl().split(";");
		String[] names = smdCeContract.getFileName().split(";");
		String[] types = smdCeContract.getFileType().split(";");
		for(int i = 0; i < urls.length; i++){
			SmdCeAttachmentEntity entity = new SmdCeAttachmentEntity();
			entity.setAttachmentUrl(urls[i]);
			for(int j = 0; j < names.length;){
				entity.setAttachmentName(names[i]);
				for(int k = 0; k < types.length;){
					entity.setAttachmentType(types[i]);
					k++;
					break;
				}
				j++;
				break;
			}
			entity.setContractId(smdCeContract.getContractId());
			entity.setCreateDate(new Date());
			entity.setState(0);
			entity.setCreateUser(smdCeContract.getCreateUser());
			entity.setCreateEmpId(smdCeContract.getCreateEmpId());
			entity.setCreateEmpName(smdCeContract.getCreateEmpName());
			smdCeAttachmentDao.save(entity);
		}
	}
	
	@Override
	public void update(SmdCeContractEntity smdCeContract){
		smdCeContractDao.update(smdCeContract);
	}
	
	@Override
	public void delete(String contractId){
		smdCeContractDao.delete(contractId);
	}
	
	@Override
	public void deleteBatch(String[] contractIds){
		smdCeContractDao.deleteBatch(contractIds);
	}

	@Override
	public List<SmdCeAttachmentEntity> getAttachmentUrls(String contractId) {
		return smdCeContractDao.getAttachmentUrls(contractId);
	}

}
