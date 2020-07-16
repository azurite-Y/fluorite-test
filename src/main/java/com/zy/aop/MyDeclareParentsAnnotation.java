package com.zy.aop;

/**
 * @author: zy;
 * @DateTime: 2020年4月26日 上午10:47:49;
 * @Description:
 */
public class MyDeclareParentsAnnotation implements AddAnnotation {

	@Override
	public void say() {
		System.out.println("AddAnnotation==我爱中国!");
	}

}
