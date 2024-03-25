package com.zy.ioc.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zy.fluorite.core.annotation.Autowired;
import org.zy.fluorite.core.interfaces.instantiation.DisposableBean;
import org.zy.fluorite.core.interfaces.instantiation.InitializingBean;
import org.zy.fluorite.core.utils.DebugUtils;

/**
 * @DateTime 2020年6月29日 下午 2:8:25;
 * @author zy(azurite-Y);
 * @Description 普通Bean注册，且通过接口设置init和destroy方法
 */
public class Teacher implements InitializingBean, DisposableBean {
	public final Logger logger = LoggerFactory.getLogger(getClass());
	
	private int tid;
	private String name;

	public Teacher() {}
	
	@Autowired
	public Teacher(User user) {
		super();
		this.tid = user.getId();
		this.name = user.getName();
		DebugUtils.log(logger, "Teacher(User user)方法调用，args："+user);
	}
	public Teacher(int tid, String name) {
		this.tid = tid;
		this.name = name;
	}
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", name=" + name + "]";
	}

	@Override
	public void destroy() throws Exception {
		DebugUtils.log(logger, "Teacher类销毁方法调用，by：destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		DebugUtils.log(logger, "Teacher类初始化方法调用，by：afterPropertiesSet()");
	}
}
