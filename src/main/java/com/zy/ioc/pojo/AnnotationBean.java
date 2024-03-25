package com.zy.ioc.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zy.fluorite.core.annotation.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @DateTime 2020年7月2日 下午3:04:57;
 * @author zy(azurite-Y);
 * @Description 注解配置初始化和销毁方法测试
 */
@Component
public class AnnotationBean {
	public final Logger logger = LoggerFactory.getLogger(getClass());
	
	@PostConstruct
	public void init() {
		logger.info("AnnotationBean 类的初始化方法调用，by：init()");
	}
	@PreDestroy
	public void destroy() {
		logger.info("AnnotationBean 类的销毁方法调用，by：destroy()");
	}
}
