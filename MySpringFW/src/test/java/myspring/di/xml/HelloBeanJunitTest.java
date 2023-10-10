package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJunitTest {
	BeanFactory factory;
	
	// 반복적으로 만들어야하는 작업이 있으면 BeforeEach 사용하기
	@BeforeEach
	void init() {
		// 1. Spring Bean Container 객체생성
		factory = new GenericXmlApplicationContext("classpath:spring-beans.xml");
	}
	
	@Test @Disabled
	void 생성자주입테스트() {
		// alt + shift + L
		Hello bean = factory.getBean("helloC", Hello.class);
		assertEquals("Hello 생성자", bean.sayHello());
		bean.print();
		
		List<String> names = bean.getNames();
		
		assertEquals(3, names.size()); // length 확인하기
		assertEquals("Spring Boot", names.get(1)); // 첫번째 값이 Spring Boot가 맞는지 체크
	}
	
	@Test @Disabled
	void hello() {
		// 2. Container가 생성한 Bean을 요청하기
		Hello hello1 = (Hello) factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class);
		// 3. HelloBean 레퍼런스 비교하기  (싱글톤인지 아닌지 비교하기 위해 즉 레퍼런스 같은지 확인)
		System.out.println(hello1 == hello2);
		Assertions.assertSame(hello1, hello2);
		// assertSame 레퍼런스 주소가 같은지 비교
		
		assertEquals("Hello 스프링", hello2.sayHello());
		// assertEquals 반환하는 값이 같은지 비교
		// sayHello에서 name 변수를 사용하고 있기 때문에 호출
		hello2.print();
		
		Printer printer = factory.getBean("strPrinter", Printer.class);
		// toString인지 비교하기
		assertEquals("Hello 스프링", printer.toString());
	}
	
	
}
