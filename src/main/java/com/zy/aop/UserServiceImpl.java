package com.zy.aop;

import org.zy.fluorite.core.annotation.Lazy;
import org.zy.fluorite.core.annotation.Service;

import java.util.List;

/**
 * @author: zy;
 * @DateTime: 2020年4月26日 上午10:37:33;
 * @Description:
 */
@Service
@Lazy
//@A
public class UserServiceImpl implements UserService{

	@Override
//	@A
	public void say(String name,int len) {
		System.out.println("==say{"+name+"-"+len+"}==");
	}

	@Override
	public List<String> say(@A String name) {
		System.out.println("==say{"+name+"}==");
		return null;
	}

}
