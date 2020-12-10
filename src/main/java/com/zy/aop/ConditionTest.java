package com.zy.aop;

import org.zy.fluorite.context.annotation.interfaces.Condition;
import org.zy.fluorite.context.annotation.interfaces.ConditionContext;
import org.zy.fluorite.core.subject.AnnotationAttributes;

/**
 * @DateTime 2020年7月16日 下午7:18:20;
 * @author zy(azurite-Y);
 * @Description
 */
public class ConditionTest implements Condition {

	@Override
	public boolean matcher(ConditionContext context, AnnotationAttributes attributes) {
		return true;
	}

}
