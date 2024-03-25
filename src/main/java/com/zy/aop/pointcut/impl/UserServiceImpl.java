package com.zy.aop.pointcut.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zy.fluorite.core.annotation.Lazy;
import org.zy.fluorite.core.annotation.Service;

import com.zy.aop.pointcut.UserService;

/**
 * @author: zy;
 * @DateTime: 2020年4月26日 上午10:37:33;
 * @Description:
 */
@Service
@Lazy
public class UserServiceImpl implements UserService{
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void say(String name,int len) {
		logger.info("UserServiceImpl.say(String, int) :: name: {}, len: {}", name, len);
	}

	@Override
	public List<String> login(String name) {
		logger.info("UserServiceImpl.login(String) ::  name: {}", name);
		List<String> list = new ArrayList<>();
		list.add(name);
		list.add("test");
		return list;
	}

	
	@Override
	public void say(String name) {
		logger.info("UserServiceImpl.say(String) ::  name: {}", name);
		int a = 1/0;
	}
}
