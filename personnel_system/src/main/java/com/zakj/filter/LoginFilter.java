package com.zakj.filter;

import com.zakj.personnel.entity.SessionUser;
import com.zakj.personnel.service.SmdEmployeeService;
import com.zakj.utils.EncrypBase;
import org.apache.commons.lang.StringUtils;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录拦截
 * ssxu
 */
/*@WebFilter(filterName="loginFilter",urlPatterns="/*")
@Component*/
//@PropertySource("classpath:aliyun.properties")
public class LoginFilter implements Filter {

	private Logger log = Logger.getLogger(LoginFilter.class);

	@Value("${SSO_SERVER_URL}")
	private String SSO_SERVER_URL;
	@Value("${SSO_SERVER_VERIFY_URL}")
	private String SSO_SERVER_VERIFY_URL;

	@Autowired
	private SmdEmployeeService smdEmployeeService;



	@Override
	public void init(FilterConfig filterConfig){

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		String authority = "";
		System.out.println("**********************************");

		if (StringUtils.isNotEmpty(request.getParameter("exit"))){  //退出  好像只能发页面上的请求   后台不能发   周一过来改成页面发请求的那种
			session.invalidate();
			log.info("收费退出成功");
		} else {
			String path = request.getScheme() + "://"
					+ request.getServerName() + ":"
					+ request.getServerPort()
					+ request.getRequestURI();
			if(request.getParameter("token") != null) {
				// 验证token有效性
				response.sendRedirect(SSO_SERVER_VERIFY_URL + "?token=" + request.getParameter("token") + "&callback=" + path);
				return;
			} else if (request.getParameter("params") != null){
				// 验证成功  返回数据
				String params = request.getParameter("params").replaceAll(" ", "+");
				// 解密
				SessionUser user = com.alibaba.fastjson.JSON.parseObject(EncrypBase.decodeStr(params),SessionUser.class);
				try {
					log.info("人事开始设置session"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					Map<String, Object> map1=new HashMap<String, Object>();
					map1.put("userId", user.getUserId());
					Map<String, Object> map=	smdEmployeeService.login(map1);
					session.setAttribute("tenantId", map.get("tenant_id"));
					session.setAttribute("orgId", map.get("org_id"));
					session.setAttribute("gradeId", map.get("grade_id"));
					session.setAttribute("clazzId", map.get("clazz_id"));
					session.setAttribute("employeeId", map.get("employee_id"));
					session.setAttribute("employeeName", map.get("employee_name"));
					session.setAttribute("employeeJob", map.get("employee_job"));
					session.setAttribute("employeeJobId",map.get("employee_job_id"));
					session.setAttribute("employeeDept", map.get("employee_dept"));
					session.setAttribute("userId", user.getUserId());
//					session.setAttribute("tenantId", user.getTenantId());
//					session.setAttribute("orgId", user.getOrgId());
					session.setAttribute("userName", user.getUserName());
					session.setAttribute("token", user.getToken());
					log.info("人事设置session完毕"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"id==="+session.getAttribute("userId"));
					// 为了不让地址栏带有加密的token参数
					response.sendRedirect(path);
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (null != session.getAttribute("userId") && StringUtils.isNotEmpty(session.getAttribute("userId").toString())) {
				chain.doFilter(req, res);
				return;
			}
			
			// 跳转至sso认证中心
			String callbackURL = request.getRequestURL().toString();
			StringBuilder url = new StringBuilder();
			url.append(SSO_SERVER_URL).append("?callbackURL=").append(callbackURL);
			if (StringUtils.isNotEmpty(authority)) {
				url.append("&authority=").append(authority);
			}

			System.out.println("url=*** "+url.toString());
			response.sendRedirect(url.toString());
		}
	}

	@Override
	public void destroy() {
	}
}
