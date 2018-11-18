package com.zakj;

import com.zakj.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * 类描述：附件上传大小设置
 * 创建人：ssxu
 * 创建时间：2018-3-3 下午4:13:33
 *
 * @version 1.0
 */
@Configuration
public class MultipartConfig {

    @Bean
    public FilterRegistrationBean filterDemo3Registration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(loginFilter());
        registration.addUrlPatterns("/*");
        //registration.addInitParameter("paramName", "paramValue");
        registration.setName("loginFilter");
        registration.setOrder(6);
        return registration;
    }

    @Bean
    public Filter loginFilter() {
        return new LoginFilter();
    }
}
