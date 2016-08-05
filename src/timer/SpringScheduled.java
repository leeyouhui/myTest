package timer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("doWork")
@Lazy(false)
public class SpringScheduled {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("classpath:timer/spring1.xml");
	}

	@Scheduled(cron = "0/2 * * * * ?")
	public void doWork(){
		System.out.println("do working ... ");
	}
	
	@PostConstruct
	public void initMethod(){
		System.out.println("init ing ... ");
	}
	
	@PreDestroy	
	public void desMethod(){
		System.out.println("destroy ing ... ");
	}
}
