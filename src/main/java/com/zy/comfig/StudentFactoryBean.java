package com.zy.comfig;

import com.zy.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zy.fluorite.core.annotation.Component;
import org.zy.fluorite.core.interfaces.instantiation.SmartFactoryBean;
import org.zy.fluorite.core.utils.DebugUtils;

/**
 * 实例化工厂
 */
@Component("student")
public class StudentFactoryBean implements SmartFactoryBean<Student> {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public Student getObject() throws Exception {
		Student student = new Student(2, "StudentFactoryBean对象实例化", 8);
		DebugUtils.log(logger, "StudentFactoryBean.getObject()方法调用，实例："+student+"this："+this);
		return student;
	}

	@Override
	public Class<?> getObjectType() {
		return Student.class;
	}

	@Override
	public boolean isSingleton() {
		// 标识工厂不是单例的
		return true;
	}

	@Override
	public boolean isEagerInit() {
		return true; // 急切的进行初始化
	}

	@Override // 未调用
	public boolean isPrototype() {
		return false;
	}

}
