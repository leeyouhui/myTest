package timer;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class TimerTest {
	
	@Autowired
	private TimerTest r;
	public TimerTest() {
		new Timer().schedule(new MyTask(), 1000, 2000);
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("classpath:timer/spring.xml");
	}
	
	public void init(){
		System.out.println("---i am a init() method1---");
		new Timer().schedule(new MyTask(), 1000, 2000);
		System.out.println("---i am a init() method2---");
	}

}

class MyTask extends TimerTask{

	@Override
	public void run() {
		System.out.println("-----MyTask-----");
	}

}