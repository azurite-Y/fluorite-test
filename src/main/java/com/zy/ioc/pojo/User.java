package com.zy.ioc.pojo;

import org.zy.fluorite.core.annotation.Component;
import org.zy.fluorite.core.annotation.Value;

/**
 * @DateTime 2020年6月29日 下午1:57:13;
 * @author zy(azurite-Y);
 * @Description 普通Bean注册，且通过@Value从配置文件中获得指定属性
 */
@Component
public class User {
	@Value("#{user.id}")
	private int id;
	
	@Value("#{user.name}")
	private String name;
	
	@Value("#{user.age}")
	private int age;

	public User() {
		super();
	}
	
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public User(String name) {
		super();
		this.name = name;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public User(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
