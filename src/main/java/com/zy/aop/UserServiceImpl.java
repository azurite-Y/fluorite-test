package com.zy.aop;

import java.util.List;

import org.zy.fluorite.core.annotation.Lazy;
import org.zy.fluorite.core.annotation.Service;

/**
 * @author: zy;
 * @DateTime: 2020年4月26日 上午10:37:33;
 * @Description:
 */
@Service
@Lazy
public class UserServiceImpl implements UserService{

	@Override
	public void say(String name,int len) {
		System.out.println("==say{"+name+"-"+len+"}==");
//		throw new IllegalArgumentException("异常通知...");
	}

	@Override
	public List<String> say(String name) {
		System.out.println("==say{"+name+"}==");
		return null;
	}

}
