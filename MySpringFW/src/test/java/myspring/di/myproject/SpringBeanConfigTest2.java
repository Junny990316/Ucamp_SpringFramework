package myspring.di.myproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.strategy1.service2.UserService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/resources/spring-beans-configuration2.xml")
public class SpringBeanConfigTest2 {
	@Autowired
	UserService UserService;
	
	@Test
	public void userTest() {
		assertEquals(2, UserService.getUserList().size());
	}
}
