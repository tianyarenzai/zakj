package com.zakj.security.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 自定义注解示例
 * @author wangkl
 *
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface AjaxAnnotation {

}
