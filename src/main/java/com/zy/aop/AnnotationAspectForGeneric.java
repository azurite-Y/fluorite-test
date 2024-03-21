package com.zy.aop;

import org.zy.fluorite.aop.aspectj.annotation.*;
import org.zy.fluorite.aop.aspectj.interfaces.JoinPoint;
import org.zy.fluorite.aop.aspectj.interfaces.ProceedingJoinPoint;
import org.zy.fluorite.core.annotation.Component;
import org.zy.fluorite.core.annotation.Order;
import org.zy.fluorite.core.interfaces.Ordered;

/**
 * @DateTime 2020年7月14日 下午7:39:10;
 * @author zy(azurite-Y);
 * @Description
 */
@Aspect
@Component
public class AnnotationAspectForGeneric {
	@Pointcut(value = "com.zy.aop.UserServiceImpl.say()", args = { String.class},
			prefix = "execution", returnType = "List<String>")
	public void Pointcut() {}

	@Before(value = "Pointcut()")
	public void myBefore(JoinPoint jp) {
		System.out.println("myBefore="+jp.getJoinPointMethod().getName());
	}

	@Before(value = "Pointcut()")
	@Order(Ordered.HIGHEST_PRECEDENCE )
	public void myBefore2(JoinPoint jp) {
		System.out.println("myBefor2="+jp.getJoinPointMethod().getName());
	}
	
	@After(value = "Pointcut()")
	public void myAfter(JoinPoint jp) {
		System.out.println("myAfter="+jp.getJoinPointMethod().getName());
	}

	@AfterReturning(value = "Pointcut()")
	public void myAfterReturn(JoinPoint jp, String name) {
		System.out.println("myAfterReturn{"+name+"}="+jp.getJoinPointMethod().getName());
	}

	@AfterThrowing(value = "Pointcut()")
	public void myThrow(JoinPoint jp , Exception e) {
		System.out.println("mythrow= " + e);
	}

	@Around(value = "Pointcut()")
	public Object myArround(ProceedingJoinPoint p , String name) throws Throwable {
		System.out.println("-------------myarround方法-------------------");
		System.out.println("=环绕-前置=");
		Object result = p.proceed();
		System.out.println("=环绕-后置=");
		System.out.println("-------------myarround方法-------------------");
		return result;
	}
}
