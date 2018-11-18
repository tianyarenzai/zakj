package com.zakj.personnel.controller;

import com.zakj.personnel.service.SmdCeContractTypeService;
import com.zakj.security.common.beans.AjaxListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


/**
 * InnoDB free: 12288 kB
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
@RestController
@RequestMapping("/employee/contracttype")
public class SmdCeContractTypeController {
	@Autowired
	private SmdCeContractTypeService smdCeContractTypeService;


	/**
	 * 获取合同类型
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getContractTypes")
	@ResponseBody
	public AjaxListResult<Map<String, Object>> getContractTypes(HttpServletRequest request,
																HttpSession session)throws Exception {
		System.out.println("获取合同类型-------------------------- ");
		AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();
        String tenantId = (String)session.getAttribute("tenantId");
		List<Map<String, Object>> list = this.smdCeContractTypeService.getContractTypes(tenantId);
		result.setData(list);
		return result;
	}

	
}
