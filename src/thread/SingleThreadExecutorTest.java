package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorTest {
	static ExecutorService executor = Executors.newSingleThreadExecutor();
	public static void main(String[] args) {
		for(int i=0;i<1000;i++){
			executor.execute(new AThread(String.valueOf(i)));
		}
	}
}

class AThread implements Runnable {
	String name;
	public AThread(String name){
		this.name = name;
	}
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		System.out.println("this is "+name);
	}
}