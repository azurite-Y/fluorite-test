package com.zy;

import java.util.Arrays;
import java.util.List;

import org.zy.fluorite.aop.aspectj.advice.AspectJAfterThrowingAdvice;
import org.zy.fluorite.aop.aspectj.advice.AspectJMethodBeforeAdvice;
import org.zy.fluorite.aop.aspectj.interfaces.PointcutExpressionParse;
import org.zy.fluorite.aop.aspectj.support.AbstractAspectJAdvisorFactory;
import org.zy.fluorite.aop.aspectj.support.PointcutExpression;
import org.zy.fluorite.aop.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.zy.fluorite.aop.interfaces.Advised;
import org.zy.fluorite.aop.interfaces.function.ClassFilter;
import org.zy.fluorite.aop.proxy.CglibAopProxy;
import org.zy.fluorite.aop.proxy.JdkDynamicAopProxy;
import org.zy.fluorite.aop.support.DefaultAopProxyFactory;
import org.zy.fluorite.aop.support.adapter.ThrowsAdviceInterceptor;
import org.zy.fluorite.autoconfigure.ioc.BeanPostProcessorAutoConfiguration;
import org.zy.fluorite.beans.factory.interfaces.ConfigurableListableBeanFactory;
import org.zy.fluorite.beans.factory.interfaces.InstantiationStrategy;
import org.zy.fluorite.boot.FluoriteApplication;
import org.zy.fluorite.boot.annotation.RunnerAs;
import org.zy.fluorite.context.annotation.ConditionEvaluator;
import org.zy.fluorite.context.annotation.ConfigurationClassBeanDefinitionReader;
import org.zy.fluorite.context.annotation.ConfigurationClassParser;
import org.zy.fluorite.context.interfaces.ConfigurableApplicationContext;
import org.zy.fluorite.context.support.ApplicationContextAwareProcessor;
import org.zy.fluorite.context.support.ApplicationListenerDetector;
import org.zy.fluorite.context.support.AutowiredAnnotationBeanPostProcessor;
import org.zy.fluorite.context.support.CommonAnnotationBeanPostProcessor;
import org.zy.fluorite.context.support.ConfigurationClassPostProcessor;
import org.zy.fluorite.context.support.DefaultLifecycleProcessor;
import org.zy.fluorite.context.support.DefaultListableBeanFactory;
import org.zy.fluorite.core.annotation.Autowired;
import org.zy.fluorite.core.environment.MutablePropertySources;
import org.zy.fluorite.core.environment.Property;
import org.zy.fluorite.web.context.support.StandardServletEnvironment;

import com.zy.aop.AddAnnotation;
import com.zy.aop.UserService;
import com.zy.pojo.LazyObjectTest;

/**
 * {@link ApplicationListenerDetector}
 * 
 * {@link Property}
 * {@link StandardServletEnvironment}
 * {@link MutablePropertySources}
 * 
 * {@link ConfigurationClassPostProcessor}
 * {@link ConfigurationClassParser}
 * {@link ConfigurationClassBeanDefinitionReader}
 * {@link ConditionEvaluator}
 * 
 * {@link BeanPostProcessorAutoConfiguration}
 * 
 * {@link InstantiationStrategy}
 * {@link DefaultListableBeanFactory}
 * 
 * {@link AutowiredAnnotationBeanPostProcessor}
 * {@link CommonAnnotationBeanPostProcessor}
 * 
 * {@link ApplicationContextAwareProcessor}
 * {@link DefaultLifecycleProcessor}
 * 
 * ----------------------------------------------------
 * {@linkplain AbstractAdvisorAutoProxyCreator }
 * {@linkplain AbstractAspectJAdvisorFactory } 
 * {@linkplain ClassFilter }
 * {@linkplain PointcutExpression }
 * {@linkplain PointcutExpressionParse }
 * {@linkplain ClassFilter }
 * {@linkplain DefaultAopProxyFactory }
 * {@linkplain CglibAopProxy }
 * {@linkplain JdkDynamicAopProxy }
 * 
 * {@linkplain AspectJMethodBeforeAdvice }
 * {@linkplain ThrowsAdviceInterceptor }
 * {@linkplain AspectJAfterThrowingAdvice }
 * 
 * ps：更改AbstractAspectJAdvisorFactory.ASPECTJ_ANNOTATION_CLASSES属性中各个注解的位置可控制Advice执行顺序。
 * 越靠前者越接近目标方法，即在目标方法执行完毕之后方法会回退到最接近它的Advice方法中。
 * @DateTime 2020年6月29日 下午1:56:22;
 * @author zy(azurite-Y);
 * @Description
 */
@RunnerAs(debug = false , debugFormAop = false)
public class App {
	
	@Autowired
	private UserService userService2;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext run = FluoriteApplication.run(App.class, args);
		ConfigurableListableBeanFactory beanFactory = run.getBeanFactory();
		App bean = beanFactory.getBean("app",App.class);
		bean.run(run);
		
		bean.autowirdTest();
		System.out.println("=========================================================");
		new App().autowirdTest();
		run.close();
	}
	
	public void run(ConfigurableApplicationContext run) {
		System.out.println("==========================IOC===============================");
		ConfigurableListableBeanFactory beanFactory = run.getBeanFactory();
		List<String> beanDefinitionNames = beanFactory.getBeanDefinitionNames();
		for (String beanName : beanDefinitionNames) {
			System.out.println(beanName+"："+beanFactory.getBean(beanName));
		}
		System.out.println("==========================AOP===============================");
		LazyObjectTest bean = beanFactory.getBean("lazyObjectTest",LazyObjectTest.class);
		UserService userService = bean.getUserService();
		
		System.out.println(userService.getClass());
		userService.say("zs", 18);

		System.out.println();

		AddAnnotation add = (AddAnnotation)userService;
		add.say();

		System.out.println();
		
		Advised Adviced = (Advised)userService;
		Class<?>[] proxiedInterfaces = Adviced.getProxiedInterfaces();
		System.out.println(Arrays.asList(proxiedInterfaces));

		System.out.println();

		userService.say("zs");
		System.out.println("=========================================================");

	}
	
	public void autowirdTest(){
		System.out.println(this);
		// 此处的userService2属性从属于调用autowirdTest()方法的对象。
		System.out.println(this.userService2);  
		System.out.println(this.userService2 == null ? null : this.userService2.getClass());  
	}
}
