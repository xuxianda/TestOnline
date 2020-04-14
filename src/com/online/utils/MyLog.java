package com.online.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//注解放置的目标位置，Method是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {
	String value() default "";
}
