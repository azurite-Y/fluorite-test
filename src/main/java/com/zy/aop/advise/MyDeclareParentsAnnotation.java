package com.zy.aop.advise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: zy;
 * @DateTime: 2020年4月26日 上午10:47:49;
 * @Description:
 */
public class MyDeclareParentsAnnotation implements AddAnnotation {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void say() {
		logger.info("MyDeclareParentsAnnotation.say() :: 我爱中国！");
	}

}
