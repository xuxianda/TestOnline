package com.online.utils;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.online.domain.LogDomain;
import com.online.domain.UserDomain;
import com.online.service.LogService;

/**
 * 通知 、日志
 * 
 * @author Administrator
 *
 */

@Aspect
@Component
public class MyAspect {
	@Autowired
	private LogService logService;
	@Autowired
	private HttpServletRequest request;

	@AfterReturning("@annotation( com.online.utils.MyLog)")
	public void aroundAdvice(JoinPoint pjp) throws Throwable {
		System.out.println("开始记录日志。。。。。。。。。。。。");
		// 保存日志S
		LogDomain log = new LogDomain();
		// 从切面织入点处通过反射机制获取织入点处的方法
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		// 获取切入点所在的方法
		Method method = signature.getMethod();
		System.out.println(method);

		MyLog myLog = method.getAnnotation(MyLog.class);
		if (myLog != null) {
			String value = myLog.value();
			log.setOperation(value);// 保存获取的操作
		}

		// 获取请求的类名
		String className = pjp.getTarget().getClass().getName();
		// 获取请求的方法名
		String methodName = method.getName();
		log.setMethod(className + "." + methodName);
		// 请求的参数
		Object[] args = pjp.getArgs();
		String str2 = ArrayUtils.toString(args); // 数组转字符串(逗号分隔,首尾加大括号)
		if(str2.length()>=255) {
			str2 = str2.substring(1, 255);
		}
		// 将参数所在的数据转换未json
		log.setParams(str2);

		String d = TimeUtils.getCurrentDateTime();
		log.setCreateDate(d);

		// 获取用户名
		UserDomain user = (UserDomain) request.getSession().getAttribute("user");
		log.setUsername(user.getUsername());
		// 获取用户id地址
		log.setIp(request.getRemoteAddr());// 获取ip
		System.out.println(log);
		request.getMethod();// 获取方法

		logService.add(log);
		System.out.println("记录日志完成。。。。。。。。。。。。。");

	}

}
