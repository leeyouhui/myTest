package timer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	@SuppressWarnings("resource")
	@org.junit.Test
	public void test() {
		new ClassPathXmlApplicationContext("classpath:timer/spring.xml");
	}

}
