package com.zy.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zy.fluorite.context.interfaces.Lifecycle;
import org.zy.fluorite.context.interfaces.Phased;
import org.zy.fluorite.core.annotation.Service;
import org.zy.fluorite.core.utils.DebugUtils;

import javax.annotation.Resource;

/**
 * @DateTime 2020年7月2日 下午1:30:00;
 * @author zy(azurite-Y);
 * @Description
 */
@Service
public class LifecyclePojo2 implements Lifecycle, Phased {
	public final Logger logger = LoggerFactory.getLogger(getClass());
	private boolean isRunning;
	@Resource
	private Student student;

	public LifecyclePojo2() {
		super();
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "LifecyclePojo [student=" + student + "]";
	}

	@Override
	public void start() {
		DebugUtils.log(logger, "生命周期Bean-LifecyclePojo2启动...");
		isRunning = true;
	}

	@Override
	public void stop() {
		DebugUtils.log(logger, "生命周期Bea-LifecyclePojo2关闭...");
		isRunning = false;
	}

	@Override
	public boolean isRunning() {
		return isRunning;
	}

	@Override
	public int getPhase() {
		return 2;
	}
}
