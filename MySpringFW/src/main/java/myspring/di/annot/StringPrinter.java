package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("stringPrinter") // class 위에 호출, Bean이랑 같은 역할을 함
public class StringPrinter implements Printer {
	private StringBuffer buffer = new StringBuffer();
	
	public StringPrinter() {
		System.out.println(this.getClass().getName() + " 생성자 호출됨!!");
	}

	public void print(String message) {
		this.buffer.append(message);
	}

	public String toString() {
		return this.buffer.toString();
	}
}
