package com.zakj.personnel.service.impl;

import com.zakj.personnel.dao.AlyApSevPushMessageDao;
import com.zakj.personnel.dao.AlyApSevPushMessageItemDao;
import com.zakj.personnel.entity.AlyApSevPushMessageEntity;
import com.zakj.personnel.entity.AlyApSevPushMessageItemEntity;
import com.zakj.personnel.entity.AlyApSysPushAppEntity;
import com.zakj.personnel.service.AlyApSevPushMessageService;
import com.zakj.utils.PushMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class AlyApSevPushMessageServiceImpl implements AlyApSevPushMessageService {
    /**
     * 消息Dao
     */
    @Autowired
    private AlyApSevPushMessageDao alyApSevPushMessageDao;

    /**
     * 消息项Dao
     */
    @Autowired
    private AlyApSevPushMessageItemDao alyApSevPushMessageItemDao;

    @Override
    public AlyApSevPushMessageEntity queryObject(Long messageId) {
        return alyApSevPushMessageDao.queryObject(messageId);
    }

    @Override
    public List<Map<String, Object>> queryList(Map<String, Object> map) {
        return alyApSevPushMessageDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return alyApSevPushMessageDao.queryTotal(map);
    }

    @Override
    public void save(AlyApSevPushMessageEntity alyApSevPushMessage) throws Exception {
        // 1.查询App的信息
        AlyApSysPushAppEntity appEntity = alyApSevPushMessageDao.getAppInfo(alyApSevPushMessage.getTenantId());  // alyApSevPushMessage.getTenantId() 402881f85c5d670d015c5d6938b50000
        if (appEntity != null) {
            // 1.将消息推送给设备
            PushMessage pushTest = new PushMessage();
            Map<String, Object> returnMap = pushTest.PushMessageToAndroid(alyApSevPushMessage, appEntity.getRegionId(),
                    appEntity.getAccessKeyId(), appEntity.getAccessKeySecret(),
                    appEntity.getAppKey());
            System.out.println("returnMap: ------------------------------- " + returnMap.toString());
            String requestId = returnMap.get("requestId").toString();
            String messageId = returnMap.get("messageId").toString();
            String deviceId = returnMap.get("deviceId").toString();
            alyApSevPushMessage.setRequestId(requestId);
            alyApSevPushMessage.setMessageId(Long.parseLong(messageId));
            alyApSevPushMessage.setEquipment("android");

            // 2.保存推送消息
            alyApSevPushMessageDao.save(alyApSevPushMessage);

            // 3.保存消息项
            AlyApSevPushMessageItemEntity itemEntity = new AlyApSevPushMessageItemEntity();
            itemEntity.setMessageId(Long.parseLong(messageId));
            itemEntity.setDeviceId(deviceId);
            itemEntity.setIsDelivery(0);
            itemEntity.setCreateTime(new Date());
            itemEntity.setIsOpen(0);
            itemEntity.setIsDelete(0);
            alyApSevPushMessageItemDao.save(itemEntity);
        }
    }

    @Override
    public void update(AlyApSevPushMessageEntity alyApSevPushMessage) {
        alyApSevPushMessageDao.update(alyApSevPushMessage);
    }

    @Override
    public void delete(Long messageId) {
        alyApSevPushMessageDao.delete(messageId);
    }

    @Override
    public void deleteBatch(Long[] messageIds) {
        alyApSevPushMessageDao.deleteBatch(messageIds);
    }
}
