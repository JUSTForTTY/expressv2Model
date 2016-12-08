package com.hundsun.jresplus.quickstart.common.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.hundsun.jresplus.quickstart.enums.PermissionEnum;


/**
 * 
 * @author zhangsen
 *
 */
@Target( { ElementType.METHOD, ElementType.TYPE, ElementType.PACKAGE })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAccess {
	PermissionEnum[] value() default {};
}