package myspring.di.myproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.strategy1.dao.UserDao;
import myspring.di.strategy1.service.UserService;


public class SpringBeanConfigTest {
	BeanFactory factory;
	
	@BeforeEach
	void init() {
		factory = new GenericXmlApplicationContext("classpath:spring-beans-configuration.xml");
	}
	
	@Test
	void userTest() {
		UserService userService = factory.getBean("userService", UserService.class);
		UserDao userDao = factory.getBean("userDao", UserDao.class);
		
		assertEquals(2, userService.getUserList().size());
	}
	
}
