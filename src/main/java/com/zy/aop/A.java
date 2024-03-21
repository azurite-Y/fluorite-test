package com.zy.aop;

import java.lang.annotation.*;

/**
 * @DateTime 2020年7月16日 下午7:18:06;
 * @author zy(azurite-Y);
 * @Description
 */
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Conditional(ConditionTest.class)
public @interface A {

}
