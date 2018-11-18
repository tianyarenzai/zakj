package com.zakj.personnel.dao;

import com.zakj.personnel.entity.SmdCeAttachmentEntity;
import com.zakj.personnel.entity.SmdCeContractEntity;
import com.zakj.security.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 12288 kB; (`employee_id`) REFER `renren_fast/smd_employee`(`employe
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
@Mapper
public interface SmdCeContractDao extends BaseDao<SmdCeContractEntity> {
    /**
     * 获取合同附件
     * @param contractId
     * @return
     */
    List<SmdCeAttachmentEntity> getAttachmentUrls(String contractId);

}
