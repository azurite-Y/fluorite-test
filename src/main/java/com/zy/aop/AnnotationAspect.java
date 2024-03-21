package com.zy.aop;

import org.zy.fluorite.aop.aspectj.annotation.*;
import org.zy.fluorite.aop.aspectj.interfaces.JoinPoint;
import org.zy.fluorite.aop.aspectj.interfaces.ProceedingJoinPoint;
import org.zy.fluorite.core.annotation.Component;
import org.zy.fluorite.core.annotation.Order;
import org.zy.fluorite.core.interfaces.Ordered;

/**
 * @DateTime 2020年7月10日 上午9:27:44;
 * @author zy(azurite-Y);
 * @Description
 * 
 */
@Aspect
@Component
public class AnnotationAspect {
	/**
	 * 定义一个方法,用于声明切点表达式,该方法方法体一般没有内容。
	 * <p>
	 * 因为Aspect相关的注解属性都是描述目标方法的，所以在查找此方法时直接使用的方法名查找。<br/>
	 * 这也就意味着连接点方法只能定义为一个无参方法。否则将无法找到对应的连接点方法
	 * </p>
	 * @Pointcut - 用来声明切点表达式 通知直接使用定义的方法名即可引入当前的切点表达式。
	 */
//	@Pointcut(value = "com.zy.aop.UserServiceImpl.say()", args = { String.class,
//		int.class }, prefix = "execution", returnType = "void")
//	@Pointcut(value="com.zy.aop.A" , prefix = "@annotation")
	@Pointcut(value="com.zy.aop.A" , prefix = "@args")
//	@Pointcut(value="com.zy.aop.A" , prefix = "@within")
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
	public void myAfterReturn(JoinPoint jp) {
		System.out.println("myAfterReturn="+jp.getJoinPointMethod().getName());
	}

	@AfterThrowing(value = "Pointcut()")
	public void myThrow(JoinPoint jp , Exception e) {
		System.out.println("mythrow= " + e);
	}

	@Around(value = "Pointcut()")
	public Object myArround(ProceedingJoinPoint p) throws Throwable {
		System.out.println("-------------myarround方法-------------------");
		System.out.println("=环绕-前置=");
		Object result = p.proceed();
		System.out.println("=环绕-后置=");
		System.out.println("-------------myarround方法-------------------");
		return result;
	}
	
	@DeclareParents(value = "com.zy.aop.UserServiceImpl+", defaultImpl = MyDeclareParentsAnnotation.class)
	public AddAnnotation  addAnnotation;
}
