package test;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JunitTest {
	
	
	private static ApplicationContext context;
	
	@Resource(name="str")
	private String str;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("test/spring.xml");
		System.out.println("---------");
	}

	@Test
	public void test() {
		System.out.println("----test-----"+str);
	}

}
