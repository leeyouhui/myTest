package timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsScheduled {

	private static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

	public static void main(String[] args) {
		int i = 0;
		while(i<10){
			i++;
			try {
				Thread.sleep(4000);
			} catch (Exception e) {
			}
			executor.scheduleAtFixedRate(new MyScheduledExecutor(String.valueOf(i)), 0, 5, TimeUnit.SECONDS);
		}
	}

	
}
class MyScheduledExecutor implements Runnable {
	private String name;
	
	public MyScheduledExecutor(String name){
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("-----------"+name);
		
	}
	
}