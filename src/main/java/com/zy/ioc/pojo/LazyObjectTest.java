package com.zy.ioc.pojo;

import com.zy.aop.pointcut.UserService;
import org.zy.fluorite.core.annotation.Autowired;
import org.zy.fluorite.core.annotation.Component;

/**
 * @DateTime 2020年7月16日 下午2:10:46;
 * @author zy(azurite-Y);
 * @Description
 */
@Component
public class LazyObjectTest {
	@Autowired
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
}
