package com.zy;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zy.fluorite.aop.aspectj.support.AbstractAspectJAdvisorFactory;
import org.zy.fluorite.beans.factory.interfaces.ConfigurableListableBeanFactory;
import org.zy.fluorite.boot.FluoriteApplication;
import org.zy.fluorite.boot.annotation.RunnerAs;
import org.zy.fluorite.context.interfaces.ConfigurableApplicationContext;
import org.zy.fluorite.core.annotation.Autowired;

import com.zy.aop.advise.AddAnnotation;
import com.zy.aop.pointcut.StudentService;
import com.zy.aop.pointcut.TeacherService;
import com.zy.aop.pointcut.UserService;

/**
 * 1. 更改 {@link AbstractAspectJAdvisorFactory#ASPECTJ_ANNOTATION_CLASSES } 属性中各个注解的位置可控制Advice执行顺序。
 * 越靠前者越接近目标方法，即在目标方法执行完毕之后方法会回退到最接近它的Advice方法中。
 * 
 * 2. 因为开发 devtools 功能模块时未想起来连同组件索引功能逻辑部分一起更新，这就导致虽然设计组件索引功能时考虑到会依托 devtools 功能。
 * 但现在因为组件索引功能还未更新，这导致了如果第一次运行程序在类加载路径下生成组件索引，那么之后若新增加了新组件则需要手动删除此文件以进行文件扫描。
 * 否则程序将直接读取组件索引结果而不进行文件扫描。
 * 
 * @DateTime 2020年6月29日 下午1:56:22;
 * @author zy(azurite-Y);
 * @Description
 */
@RunnerAs(debug = false , debugFormAop = false)
public class App {
	private final Logger logger = LoggerFactory.getLogger(getClass());


	@Autowired
	private UserService userService;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = FluoriteApplication.run(App.class, args);
		ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
		App bean = beanFactory.getBean("app",App.class);

		bean.ioc(applicationContext);
		bean.aop();

		applicationContext.close();
	}

	public void ioc(ConfigurableApplicationContext run) {
		logger.info("======== IOC ========");
		ConfigurableListableBeanFactory beanFactory = run.getBeanFactory();
		List<String> beanDefinitionNames = beanFactory.getBeanDefinitionNames();
		logger.info("IOC Container Bean:");
		for (String beanName : beanDefinitionNames) {
			logger.info("\t--> BeanName: {} :: Bean: {}", beanName, beanFactory.getBean(beanName));
		}
		System.out.println();
		
		logger.info("IOC Bean 和手动实例化对象使用对比:");
		logger.info("==== IOC 对象自动注入测试 ====");
		this.autowirdTest();
		logger.info("==== 新建对象 ====");
		new App().autowirdTest();
		System.out.println();
	}

	public void aop() {
		logger.info("======== AOP ========");

		// ==== prefix = "@within" ====
		teacherService.say();
		System.out.println();

		teacherService.say("ww");
		System.out.println();

		// ==== prefix = "@annotation" ====
		studentService.say();
		System.out.println();

		// ==== prefix = "@args" ====
		studentService.say("tom");
		System.out.println();

		// ==== 未定义切面 ====
		studentService.say("tom", 20);
		System.out.println();

		// ==== prefix = "execution" ====
		userService.say("zs", 18);
		System.out.println();

		userService.login("zs");
		System.out.println();

		try {
			userService.say("tom");
		} catch (Exception ignore) {
			// @AfterThrowing 切面方法已处理，忽略
		}
		System.out.println();

		// 为指定的目标类引入新的属性和方法测试
		AddAnnotation addAnnotation = (AddAnnotation)userService;
		addAnnotation.say();
	}

	public void autowirdTest(){
		logger.info("this: {}", this);
		logger.info("this.userService: {}", this.userService == null ? null : this.userService.getClass());
	}
}