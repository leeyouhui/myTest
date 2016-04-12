package single;

/**
 * 单例模式的最佳实践
 * @FileName:SingleInstance.java 
 * @Author: liyouhui
 * @Date: 2016年4月11日 下午4:00:55
 * @since:  JDK 1.8
 */
public class SingleInstance {
	/**
	 * 1
	 */
	private static class InstanceHolder {  
        public static final SingleInstance instance = new SingleInstance();  
    }  
	
	/**
	 * 2
	 */
    public static SingleInstance getInstance() {  
        return InstanceHolder.instance;  
    }
    
    public void doSomething(Thread t){
    	System.out.println("------doSomething-------:"+t.getName());
    }
    
    public static void main(String[] args) {
    	MyThread m1 = new MyThread("m1");
    	MyThread m2 = new MyThread("m2");
    	
    	m1.start();
    	m2.start();
	}
}
class MyThread extends Thread{

	public MyThread(String name){
		this.setName(name);
	}
	@Override
	public void run() {
		int i = 0 ;
		while(i<10){
			SingleInstance.getInstance().doSomething(this);
			i++;
		}
	}
	
}