package com.zy.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.zy.fluorite.context.annotation.conditional.Conditional;

/**
 * @DateTime 2020年7月16日 下午7:18:06;
 * @author zy(azurite-Y);
 * @Description
 */
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(ConditionTest.class)
public @interface A {

}
