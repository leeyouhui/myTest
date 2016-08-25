package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadAndScheduleTest {

	public static void main(String[] args) {
		ExecutorService cachedPool = Executors.newCachedThreadPool();
		cachedPool.execute(new MyThread("thread 1"));
		
		ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(100);
		scheduledPool.schedule(new MyThread("thread 2"), 2, TimeUnit.SECONDS);
		scheduledPool.scheduleAtFixedRate(new MyThread("thread 3"), 1, 3, TimeUnit.SECONDS);
		scheduledPool.scheduleWithFixedDelay(new MyThread("thread 4"), 1, 5, TimeUnit.SECONDS);
		
	}

}


class MyThread implements Runnable{
	
	private String name;
	
	public MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + "-----MyThread------");
		
	}
	
}
