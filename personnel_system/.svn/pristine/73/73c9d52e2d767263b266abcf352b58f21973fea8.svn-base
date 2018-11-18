package com.zakj.security.aspect;

import com.alibaba.fastjson.JSON;
import com.zakj.security.entity.SysLogEntity;
import com.zakj.security.services.SysLogService;
import com.zakj.utils.HttpContextUtils;
import com.zakj.utils.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;




/**
 * 系统日志，切面处理类
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017年3月8日 上午11:07:35
 */
@Aspect
@Component
public class SysLogAspect {
	@Autowired
	private SysLogService sysLogService;
	
	@Pointcut("@annotation(com.zakj.security.aspect.SysLog)")
	public void logPointCut() { 
		
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		//执行方法
		Object result = point.proceed();
		//执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;

		//保存日志
		saveSysLog(point, time);

		return result;
	}

	private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		SysLogEntity sysLog = new SysLogEntity();
		SysLog syslog = method.getAnnotation(SysLog.class);
		if(syslog != null){
			/**
			 * 注解上的描述
			 */
			sysLog.setOperation(syslog.value());
		}

		/**
		 * 请求的方法名
		 */
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");
		/**
		 * 请求的参数
		 */
		Object[] args = joinPoint.getArgs();
		
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
	
		try{


			Map<String, String[]> tmp = request.getParameterMap();
			StringBuffer sb=new StringBuffer();
			for (String key : tmp.keySet()) {
				String[] values = tmp.get(key);
				System.out.println(values[0].trim());
				sb.append(key+":").append(values[0].trim()).append(" ");
			}
			sysLog.setParams(sb.toString());

		}catch (Exception e){
			//String params = new Gson().toJson(args[0]);
			String params = JSON.toJSONString(args[0]);
			sysLog.setParams(params);

                }

			 
		/**
		 * 设置IP地址
		 */
		sysLog.setIp(IPUtils.getIpAddr(request));
	 	HttpSession session = request.getSession(); 	
			
		String tenantId = (String) session.getAttribute("tenantId");
		String userId = (String) session.getAttribute("userId");
		String employeeName = (String) session.getAttribute("employeeName");
		String empId = (String) session.getAttribute("employeeId");
		String orgId = (String) session.getAttribute("orgId");
		sysLog.setUsername(employeeName);
		sysLog.setTime(time);
		sysLog.setCreateDate(new Date());
		sysLog.setEmpId(empId);
		sysLog.setOrgId(orgId);
		sysLog.setUserId(userId);
		sysLog.setTime(time);
		sysLog.setTenantId(tenantId);
		sysLogService.save(sysLog);
			 
	
	}
}
