package myspring.di.strategy1.test3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.strategy1.config2.UserConfig2;
import myspring.di.strategy1.service2.UserService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserConfig2.class,
					  loader = AnnotationConfigContextLoader.class)
public class SpringConfigTest3 {
	@Autowired
	UserService UserService;
	
	@Test
	public void userTest() {
		assertEquals(2, UserService.getUserList().size());
	}
}
