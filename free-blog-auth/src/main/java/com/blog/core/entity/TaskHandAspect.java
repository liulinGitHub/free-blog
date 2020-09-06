package com.blog.core.entity;

import com.google.common.base.Throwables;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @program: TaskHandAspect
 * @description:
 * @author: 950103
 * @create: 2020-06-15 09:49
 * @Version: 1.0
 */
@Aspect
@Component
public class TaskHandAspect {

	@Pointcut("@annotation(com.blog.core.entity.TaskHandHandler)")
	public void pointcut() {
	}

	@Around("pointcut()")
	public Object handlerDateTime(ProceedingJoinPoint point) throws Throwable {
		Object[] args = point.getArgs();
		for (Object o : args) {
			Field[] fields = o.getClass().getDeclaredFields();
			o.getClass().isInterface();
			for (Field field : fields) {
				field.setAccessible(true);
				field.getName();
				Object value = field.get(o);
			}
		}
		return point.proceed();
	}

	@AfterReturning(returning = "o",pointcut = "pointcut()")
	public void methodAfterReturing(Object o ){
		System.out.println("--------------返回内容----------------");

		System.out.println("Response内容:"+ o);

		System.out.println("--------------返回内容----------------");
	}

	@AfterThrowing(pointcut="pointcut()",throwing="e")
	public void afterThrowable(JoinPoint joinPoint, Throwable e) {
		//方法名获取
		String methodName = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
		System.out.println("请求异常：请求方法："+methodName+", 异常信息：{"+Throwables.getStackTraceAsString(e)+"}");
	}
}
