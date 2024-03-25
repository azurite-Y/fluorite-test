package com.zy.ioc.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @DateTime 2020年6月29日 下午 14:05:13;
 * @author zy(azurite-Y);
 * @Description 普通Bean注册，且设置init和destroy方法
 */
public class Student {
	public final Logger logger = LoggerFactory.getLogger(getClass());
	
	private int id;
	
	private String name;
	
	private int tid;

	public Student() {
		super();
	}
	public Student(int id, String name, int tid) {
		super();
		this.id = id;
		this.name = name;
		this.tid = tid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", tid=" + tid + "]";
	}
	
}
