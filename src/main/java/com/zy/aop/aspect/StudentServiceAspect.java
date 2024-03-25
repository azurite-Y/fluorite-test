package com.zy.aop.aspect;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zy.fluorite.aop.aspectj.annotation.After;
import org.zy.fluorite.aop.aspectj.annotation.AfterReturning;
import org.zy.fluorite.aop.aspectj.annotation.Aspect;
import org.zy.fluorite.aop.aspectj.annotation.Before;
import org.zy.fluorite.aop.aspectj.annotation.Pointcut;
import org.zy.fluorite.aop.aspectj.interfaces.JoinPoint;
import org.zy.fluorite.core.annotation.Component;


@Component
@Aspect
public class StudentServiceAspect {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 定义一个方法,用于声明切点表达式,该方法方法体一般没有内容。
	 * <p>
	 * 因为Aspect相关的注解属性都是描述目标方法的，所以在查找此方法时直接使用的方法名查找。<br/>
	 * 这也就意味着连接点方法只能定义为一个无参方法。否则将无法找到对应的连接点方法
	 * </p>
	 * @Pointcut - 用来声明切点表达式 通知直接使用定义的方法名即可引入当前的切点表达式。
	 */
	@Pointcut(value="com.zy.aop.advise.ParameterPointcutAnnotation" , prefix = "@args")
	public void parameterPointcut() {}

	@Before(value = "parameterPointcut()")
	public void myBeforeToParameter(JoinPoint jp) {
		logger.info("{} :: JoinPointMethod: {}.{}(...)", "StudentServiceAspect.myBeforeToParameter",
				jp.getTarget().getClass().getSimpleName(),
				jp.getJoinPointMethod().getName());
	}

	@After(value = "parameterPointcut()")
	public void myAfterToParameter(JoinPoint jp) {
		logger.info("{} :: JoinPointMethod: {}.{}(...)", "StudentServiceAspect.myAfterToParameter",
				jp.getTarget().getClass().getSimpleName(),
				jp.getJoinPointMethod().getName());
	}

	@AfterReturning(value = "parameterPointcut()")
	public void myAfterReturnToParameter(JoinPoint jp, String name) {
		logger.info("{} :: JoinPointMethod: {}.{}(...) :: returnValue: {}", "StudentServiceAspect.myAfterReturnToParameter",
				jp.getTarget().getClass().getSimpleName(),
				jp.getJoinPointMethod().getName(),
				name);
	}

	// ---------------------------------------
	@Pointcut(value = "com.zy.aop.advise.MethodPointcutAnnotation", prefix = "@annotation")
	public void methodPointcut() {}
	
	@Before(value = "methodPointcut()")
	public void myBeforeToMethod(JoinPoint jp) {
		logger.info("{} :: JoinPointMethod: {}.{}(...)", "StudentServiceAspect.myBeforeToMethod",
				jp.getTarget().getClass().getSimpleName(),
				jp.getJoinPointMethod().getName());
	}

	@After(value = "methodPointcut()")
	public void myAfterToMethod(JoinPoint jp) {
		logger.info("{} :: JoinPointMethod: {}.{}(...)", "StudentServiceAspect.myAfterToMethod", 
				jp.getTarget().getClass().getSimpleName(),
				jp.getJoinPointMethod().getName());
	}
	
}
