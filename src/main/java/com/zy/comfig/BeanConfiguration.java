package com.zy.comfig;

import com.zy.pojo.People;
import com.zy.pojo.Teacher;
import com.zy.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zy.fluorite.context.annotation.conditional.ConditionalOnProperty;
import org.zy.fluorite.context.annotation.conditional.ConditionalOnResource;
import org.zy.fluorite.core.annotation.Bean;
import org.zy.fluorite.core.annotation.Configuration;
import org.zy.fluorite.core.annotation.Lazy;

/**
 * @DateTime 2020年6月29日 下午2:16:40;
 * @author zy(azurite-Y);
 * @Description
 */
@Configuration
public class BeanConfiguration {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Bean(initMethod = "afterPropertiesSet",destroyMethod = "destroy")
	// 在配置文件中存在 'fluorite.application.name' 和 'fluorite.scanner.component.index'属性才注册
	@ConditionalOnProperty(prefix = "fluorite." , value = {"application.name","scanner.component.index"  })
	public People createPeople() {
		return new People();
	}
	
	/**
	 * 测试方法参数注入
	 * @param user
	 * @return
	 */
	@Bean
	@ConditionalOnResource(resources = {"conditionResource.txt"})
	public Teacher createTeacher(@Lazy User user) {
		logger.info("调用createTeacher(User)方法，args："+user.getClass());
		return new Teacher(user);
	}
	
}
