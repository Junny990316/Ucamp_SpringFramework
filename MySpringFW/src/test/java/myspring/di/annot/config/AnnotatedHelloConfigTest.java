package myspring.di.annot.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.Hello;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AnnotatedHelloConfig.class, 
					   loader = AnnotationConfigContextLoader.class)
// AnnotationConfigContextLoader.class 는
// AnnotaionConfig
public class AnnotatedHelloConfigTest {
	
	@Autowired
	Hello hello;
	
	@Test
	public void hello() {
		System.out.println(hello.sayHello());
	}
}
