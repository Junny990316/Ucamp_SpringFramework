package myspring.di.xml.congif;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
public class XmlHelloConfig {
	
	@Bean
	public Printer strPrinter() {
		return new StringPrinter();
	}
	
	@Bean
	public Printer conPrinter() {
		return new ConsolePrinter();
	}
	
	@Bean
	public Hello hello() {
		Hello hello = new Hello();
		hello.setName("java config");
		hello.setPrinter(strPrinter());
		return hello;
	}
}
