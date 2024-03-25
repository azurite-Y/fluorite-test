package com.zy.aop.pointcut.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zy.fluorite.core.annotation.Service;

import com.zy.aop.advise.TypePointcutAnnotation;
import com.zy.aop.pointcut.TeacherService;


/**
  *  类级注解切面织入测试
 * @author Azurite
 *
 */
@Service
@TypePointcutAnnotation
public class TeacherServiceImpl implements TeacherService {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void say() {
		logger.info("TeacherServiceImpl.say()");
	}

	@Override
	public String say(String msg) {
		logger.info("TeacherServiceImpl.say() :: msg: {}", msg);
		return msg;
	}
}
