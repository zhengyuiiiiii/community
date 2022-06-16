package com.zhengyu.community;

import com.zhengyu.community.dao.AlphaDao;
import com.zhengyu.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;



	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Test
	public void testApplication() {
		System.out.println(applicationContext);  //直接打印该类的一个属性？证明了容器是可见、存在的

//		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);//AlphaDao.class:按照类型获取
//		System.out.println(alphaDao.select());
//
//		alphaDao = applicationContext.getBean("alphaHibernate", AlphaDao.class);
//		System.out.println(alphaDao.select());

		AlphaDao alphaDao = (AlphaDao)applicationContext.getBean("alphaHibernate");
		System.out.println(alphaDao.select());

	}

	@Test
	public void testBeanManagement() {
		AlphaService alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);

		alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}

	@Test
	public void testBeanConfig() {
		SimpleDateFormat simpleDateFormat =
				applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	@Autowired
//	@Qualifier("alphaHibernate")
	private AlphaDao alphaDao;

	@Test
	//DI是依赖注入
	public void TestDI() {
		System.out.println(alphaDao);
	}
}
