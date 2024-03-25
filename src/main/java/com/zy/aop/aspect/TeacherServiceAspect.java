package com.zy.aop.aspect;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zy.fluorite.aop.aspectj.annotation.Around;
import org.zy.fluorite.aop.aspectj.annotation.Aspect;
import org.zy.fluorite.aop.aspectj.interfaces.ProceedingJoinPoint;
import org.zy.fluorite.core.annotation.Component;


@Component
@Aspect
public class TeacherServiceAspect {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Around(value="com.zy.aop.advise.TypePointcutAnnotation" , prefix = "@within")
	public Object myArroundToType(ProceedingJoinPoint p) throws Throwable {
		logger.info("{} :: JoinPointMethod: {}.{}(...)", "TeacherServiceAspect.myAfterToParameter", 
				p.getTarget().getClass().getSimpleName(),
				p.getJoinPointMethod().getName());
		logger.info("-------------myArroundToType start -------------------");
		logger.info("=环绕-前置=");
		Object result = p.proceed();
		logger.info("=环绕-后置=");
		logger.info("-------------myArroundToType end-------------------");
		return result;
	}
}
