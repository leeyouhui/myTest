package collection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueTest {
	
	private static BlockingQueue<String> q = new LinkedBlockingQueue<>(10);//限定队列大小不支持自动扩容
	
	private static AtomicInteger c = new AtomicInteger();
 
	public static void main(String[] args) {
		new Thread(new Consumer()).start();
		new Thread(new Productor()).start();

	}
	
	private static class Productor implements Runnable {

		@Override
		public void run() {
			while(c.incrementAndGet()<100){
				try {
					Thread.sleep(2000);
					q.put("produtor : "+c.get());//没有空间将阻塞到有空间可放为止
					System.out.println("produtor : "+c.get());
//					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	static class Consumer implements Runnable {

		@Override
		public void run() {
			while(true){
				try {
//					Thread.sleep(2000);
					System.out.println("consumer : start");
					System.out.println("consumer : "+ q.take());//没有数据可取就阻塞知道有数据
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}


