package com.zy.aop.pointcut.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zy.fluorite.core.annotation.Service;

import com.zy.aop.advise.MethodPointcutAnnotation;
import com.zy.aop.advise.ParameterPointcutAnnotation;
import com.zy.aop.pointcut.StudentService;

/**
  *  参数级和方法级注解切面织入测试 
 * @author Azurite
 *
 */
@Service
public class StudentServiceImpl implements StudentService {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
    @Override
    public void say(@ParameterPointcutAnnotation String name) {
    	logger.info("StudentServiceImpl.say(String) :: name: {}", name);
    }

	@Override
	@MethodPointcutAnnotation
	public void say() {
		logger.info("StudentServiceImpl.say()");
	}

	@Override
	public void say(String name, int len) {
		logger.info("StudentServiceImpl.say(String, int) :: name: {}, len: {}", name, len);
	}
}