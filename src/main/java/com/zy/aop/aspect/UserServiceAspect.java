package com.zy.aop.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zy.fluorite.aop.aspectj.annotation.After;
import org.zy.fluorite.aop.aspectj.annotation.AfterReturning;
import org.zy.fluorite.aop.aspectj.annotation.AfterThrowing;
import org.zy.fluorite.aop.aspectj.annotation.Around;
import org.zy.fluorite.aop.aspectj.annotation.Aspect;
import org.zy.fluorite.aop.aspectj.annotation.Before;
import org.zy.fluorite.aop.aspectj.annotation.DeclareParents;
import org.zy.fluorite.aop.aspectj.annotation.Pointcut;
import org.zy.fluorite.aop.aspectj.interfaces.JoinPoint;
import org.zy.fluorite.aop.aspectj.interfaces.ProceedingJoinPoint;
import org.zy.fluorite.core.annotation.Component;

import com.zy.aop.advise.AddAnnotation;
import com.zy.aop.advise.MyDeclareParentsAnnotation;

/**
 * @DateTime 2020年7月14日 下午7:39:10;
 * @author zy(azurite-Y);
 * @Description
 */
@Aspect
@Component
public class UserServiceAspect {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Pointcut(value = "com.zy.aop.pointcut.impl.UserServiceImpl.say()",
			args = { String.class, int.class }, prefix = "execution", returnType = "void")
	public void pointcut() {}

	@Before(value = "pointcut()")
	public void myBefore(JoinPoint jp) {
		logger.info("{} :: JoinPointMethod: {}.{}(...)", "UserServiceAspect.myBefore", 
				jp.getTarget().getClass().getSimpleName(),
				jp.getJoinPointMethod().getName());
	}

	@After(value = "pointcut()")
	public void myAfter(JoinPoint jp) {
		logger.info("{} :: JoinPointMethod: {}.{}(...)", "UserServiceAspect.myAfter", 
				jp.getTarget().getClass().getSimpleName(),
				jp.getJoinPointMethod().getName());
	}

	@AfterReturning(value = "pointcut()")
	public void myAfterReturn(JoinPoint jp, String name) {
		logger.info("{} :: JoinPointMethod: {}.{}(...) :: returnValue: {}", "UserServiceAspect.myAfterReturn", 
				jp.getTarget().getClass().getSimpleName(),
				jp.getJoinPointMethod().getName(),
				name);
	}


	// ---------------------------------------------
	@Around(value = "com.zy.aop.pointcut.impl.UserServiceImpl.login()", args = { String.class }, prefix = "execution", returnType = "List<String>")
	public Object myArround(ProceedingJoinPoint p , String name) throws Throwable {
		logger.info("{} :: JoinPointMethod: {}.{}(...) :: parameter: {}", "UserServiceAspect.myArround", 
				p.getTarget().getClass().getSimpleName(),
				p.getJoinPointMethod().getName(),
				name);
		logger.info("-------------myArround start -------------------");
		logger.info("=环绕-前置=");
		Object result = p.proceed();
		logger.info("=环绕-后置=");
		logger.info("-------------myArround end-------------------");
		logger.info("{} :: returnValue: {}", "UserServiceAspect.myArround", result);
		return result;
	}

	
	// ---------------------------------------------
	@AfterThrowing(value = "com.zy.aop.pointcut.impl.UserServiceImpl.say()", args = { String.class}, 
			prefix = "execution", returnType = "void")
	public void myThrow(JoinPoint jp , String name, Exception e) {
		logger.info("{} :: JoinPointMethod: {}.{}(...):: parameter: {} :: Exception: {}({})", "UserServiceAspect.myThrow",
				jp.getTarget().getClass().getSimpleName(),
				jp.getJoinPointMethod().getName(),
				name,
				e.getClass().getTypeName(),
				e.getMessage());
	}
	

	@DeclareParents(value = "com.zy.aop.pointcut.impl.UserServiceImpl+", defaultImpl = MyDeclareParentsAnnotation.class)
	public AddAnnotation addAnnotation;
}
