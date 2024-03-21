package com.zy.aop;

import java.util.List;

/**
 * @author: zy;
 * @DateTime: 2020年4月26日 上午10:37:23;
 * @Description:
 */
public interface UserService {
	void say(String name, int len);
	List<String> say(String name);
}
