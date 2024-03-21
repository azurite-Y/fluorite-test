package com.zy;

import com.zy.aop.AddAnnotation;
import com.zy.aop.UserService;
import com.zy.pojo.LazyObjectTest;
import org.zy.fluorite.aop.interfaces.Advised;
import org.zy.fluorite.beans.factory.interfaces.ConfigurableListableBeanFactory;
import org.zy.fluorite.boot.FluoriteApplication;
import org.zy.fluorite.boot.annotation.RunnerAs;
import org.zy.fluorite.context.interfaces.ConfigurableApplicationContext;
import org.zy.fluorite.core.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * 更改AbstractAspectJAdvisorFactory.ASPECTJ_ANNOTATION_CLASSES属性中各个注解的位置可控制Advice执行顺序。
 * 越靠前者越接近目标方法，即在目标方法执行完毕之后方法会回退到最接近它的Advice方法中。
 * @DateTime 2020年6月29日 下午1:56:22;
 * @author zy(azurite-Y);
 * @Description
 */
@RunnerAs(debug = false , debugFormAop = false)
public class App {
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext run = FluoriteApplication.run(App.class, args);
		ConfigurableListableBeanFactory beanFactory = run.getBeanFactory();
		App bean = beanFactory.getBean("app",App.class);
		bean.run(run);
		
		System.out.println("==========================IOC 对象和新建对象对比==========================");
		System.out.println("==========IOC 对象自动注入测试==========");
		bean.autowirdTest();
		System.out.println("==========新建对象==========");
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
		System.out.println("==========================IOC End===============================\n");
		
		System.out.println("==========================AOP===============================");
		LazyObjectTest bean = beanFactory.getBean("lazyObjectTest",LazyObjectTest.class);
		UserService userService = bean.getUserService();
		
		System.out.println("==========原始的切点类对象对于切点方法==========");
		System.out.println(userService.getClass());
		userService.say("zs", 18);

		System.out.println("==========为切点类引入新的属性和方法测试==========");
		// 为指定的目标类引入新的属性和方法测试
		AddAnnotation add = (AddAnnotation)userService;
		add.say();

		System.out.println("==========AOP 代理测试==========");
		// Advised：AOP 内部代理切点类的代理对象的顶层接口
		Advised adviced = (Advised)userService;
		System.out.println("AOP代理的的代理接口：" + Arrays.asList(adviced.getProxiedInterfaces()));
		userService.say("zs");
		System.out.println("==========================AOP End===============================");
	}
	
	public void autowirdTest(){
		System.out.println(this);
		System.out.println(this.userService);
		System.out.println(this.userService == null ? null : this.userService.getClass());
	}
}