package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Assertions. *;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) // Spring Bean Container를 생성하는 것과 같은 역할
@ContextConfiguration(locations = "classpath:spring-beans.xml") // Spring Bean 설정 파일의 위치를 지정할 때 사용되는 어노테이션
public class HelloBeanSpringTest {
	
	@Autowired // getBean을 대체하는 어노테이션
	Hello hello; // xml에 있는 hello 타입이 같으면 우선적으로 변수명과 동일한 id로 불러옴
	
	@Autowired
	@Qualifier("helloC")
	Hello hello2;
	
	@Resource(name="helloC")
	Hello hello3;
	
	@Autowired
	@Qualifier("strPrinter")
	Printer printer;
	
	@Test
	public void helloC() {
		assertEquals("Hello 생성자", hello2.sayHello());
		assertEquals("Hello 생성자", hello3.sayHello());
	}
	
	@Test //@Disabled
	void hello() {
		assertEquals("Hello 스프링", hello.sayHello());		
		hello.print();
		assertEquals("Hello 스프링", printer.toString());
	}
	
}
