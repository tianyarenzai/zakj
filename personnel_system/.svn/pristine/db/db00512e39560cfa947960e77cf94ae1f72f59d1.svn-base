package com.zakj.personnel.service.impl;

import com.zakj.personnel.dao.SmdEmployeeJobDao;
import com.zakj.personnel.entity.SmdEmployeeJobEntity;
import com.zakj.personnel.service.SmdEmployeeJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("smdEmployeeJobService")
public class SmdEmployeeJobServiceImpl implements SmdEmployeeJobService {
    @Autowired
    private SmdEmployeeJobDao smdEmployeeJobDao;

    @Override
    public SmdEmployeeJobEntity queryObject(String employeeJobId) {
        return smdEmployeeJobDao.queryObject(employeeJobId);
    }

    @Override
    public List<Map<String, Object>> queryList(Map<String, Object> map) {
        List<Map<String, Object>> list = smdEmployeeJobDao.queryList(map);
        // 1.将获取到的职务列表信息中的学校Id取出
//        StringBuffer sbf = new StringBuffer();
//        list.forEach(maps -> {
//            if (map.containsKey("job_school") && maps.get("job_school") != null) {
//                sbf.append("'" + maps.get("job_school") + "',");
//            }
//        });
//
//        if (list.size() > 0) {
//            sbf.deleteCharAt(sbf.length() - 1);
//        }
        // 2.获取职务对应的学校
//        List<Map<String, Object>> list1 = UtilHttp.getOrganizations(sbf.toString());
//        list.forEach(map0 -> {
//            list1.forEach(map1 -> {
//                if (map0.get("job_school") != null && map0.get("job_school").equals(map1.get("org_id"))) {
//                    map0.put("school_name", map1.get("org_name"));
//                }
//            });
//        });

        return list;

    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return smdEmployeeJobDao.queryTotal(map);
    }

    @Override
    public void save(SmdEmployeeJobEntity smdEmployeeJob) {
        smdEmployeeJobDao.save(smdEmployeeJob);
    }

    @Override
    public void update(SmdEmployeeJobEntity smdEmployeeJob) {
        smdEmployeeJobDao.update(smdEmployeeJob);
    }

    @Override
    public void delete(String employeeJobId) {
        smdEmployeeJobDao.delete(employeeJobId);
    }

    @Override
    public void deleteBatch(String[] employeeJobIds) {
        smdEmployeeJobDao.deleteBatch(employeeJobIds);
    }

}
