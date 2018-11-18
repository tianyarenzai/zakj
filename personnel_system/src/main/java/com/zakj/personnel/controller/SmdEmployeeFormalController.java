package com.zakj.personnel.controller;

import com.zakj.personnel.entity.SmdEmployeeFormalEntity;
import com.zakj.personnel.service.SmdEmployeeFormalService;
import com.zakj.security.aspect.SysLog;
import com.zakj.security.common.beans.AjaxListResult;
import com.zakj.security.controller.BaseController;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;


/**
 * InnoDB free: 13312 kB
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-03 15:31:08
 */
@RestController
@RequestMapping("/employee/smdemployeeformal")
public class SmdEmployeeFormalController extends BaseController {
	@Autowired
	private SmdEmployeeFormalService smdEmployeeFormalService;

	/**
	 * 保存职工的转正信息
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@SysLog("保存职工的转正信息")
	@RequestMapping(value = "saveData", method = RequestMethod.POST)
	@ResponseBody
	public AjaxListResult<Map<String, Object>> saveData(HttpServletRequest request, HttpSession session)throws Exception{
		AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String,Object>>();
		try {
			Map<String, Object> map = this.getRequestParams(request);
			String json = map.get("data").toString();
			JSONObject jsonObject = JSONObject.fromObject(json);
			SmdEmployeeFormalEntity empFormal = (SmdEmployeeFormalEntity) JSONObject.
					toBean(jsonObject, SmdEmployeeFormalEntity.class);
			System.out.println("contractNo: --------------------------- " + empFormal.getContractNo());
			String userId = (String) session.getAttribute("userId");
			String userName = (String)session.getAttribute("userName");
			empFormal.setCreateUser(userName);
			empFormal.setCreateTime(new Date());
			this.smdEmployeeFormalService.save(empFormal);
			result.setCode(0);
			result.setMsg("保存成功");
		} catch (Exception e) {
			result.setCode(101);
			result.setMsg("保存失败");
			e.printStackTrace();
		}
		return result;
	}

	
}
