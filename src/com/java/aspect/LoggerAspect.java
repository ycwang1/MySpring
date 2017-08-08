package com.java.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoggerAspect {
	@Around(value="execution(* com.java.service.ProductService.*(..))")
	public Object log(ProceedingJoinPoint joinPoint)throws Throwable{
		System.out.println("start log:"+joinPoint.getSignature().getName());
		long time = System.currentTimeMillis();
		Object object=joinPoint.proceed();
		System.out.println("end log:"+joinPoint.getSignature().getName());
		long time1=System.currentTimeMillis();
		System.out.println("项目运行时间为："+(time1-time));
		return object;
	}
}	
