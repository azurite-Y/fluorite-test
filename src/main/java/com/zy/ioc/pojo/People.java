package com.zy.ioc.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zy.fluorite.core.annotation.Autowired;
import org.zy.fluorite.core.annotation.Value;
import org.zy.fluorite.core.interfaces.instantiation.InitializingBean;
import org.zy.fluorite.core.utils.DebugUtils;

/**
 * @DateTime 2020年6月29日 下午2:9:06;
 * @author zy(azurite-Y);
 * @Description 通过@Bean注册指定init和，且使用自动注入功能填充属性
 */
public class People implements InitializingBean{
	public final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("student")
	private Student student;

	private Teacher teacher;

	public People() {
		super();
	}
	public People(Student student, Teacher teacher) {
		super();
		this.student = student;
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	@Autowired
	public void setTeacher(Teacher teacher) {
		logger.info("Teacher 类的自动注入方法执行，by：setTeacher(Teacher) args："+teacher.getClass());
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void afterPropertiesSet() {
		DebugUtils.log(logger, "People 类的初始化方法调用，by：afterPropertiesSet()");
	}

	public void destroy() {
		DebugUtils.log(logger, "People 类的销毁方法调用，by：destroy()");
	}
	
	@Override
	public String toString() {
		return "People [student=" + student + ", teacher=" + teacher + "]";
	}
}
