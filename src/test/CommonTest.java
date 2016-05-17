package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

public class CommonTest {

	@Test
	public void test() {
//		StringBuffer errMsg = new StringBuffer("部分采购订单审核失败，有以下采购订单号：");
//		int i = 0;
//		while (i < 3) {
//			errMsg.append("123").append("、");
//			i++;
//		}
//		String str = errMsg.substring(0, errMsg.length()-1);
//		System.out.println(errMsg.substring(0, errMsg.length()-1));
//		System.out.println(str);
//		strs(new String("abc"), new String("123"));
//		
//		List<String> list = new ArrayList<String>();
//		list.add("1");
//		list.add("2");
//		list.add("3");
//		System.out.println(list.contains("4"));
//		System.out.println(UUID.randomUUID());
		
		double d = (double)Math.round(0.835355555*100)/100;
		System.out.println(d);
	}
	
	@Test
	public void  testClassNameTest(){
		Map<String, Object> map =  new HashMap<String, Object>();
		map.put("taxTotalAmount", 2.36084207E7);
		map.put("orderTotalQuantity", 281382);
		map.put("orderAmount",2.36086567E7);
		
		System.out.println(new BigDecimal((Double)map.get("taxTotalAmount")).toPlainString());
//		classNameTest("123");
//		Test01.fun();
	}

	public void strs(Object... os) {
		for (Object o : os)
			System.out.println(o.getClass().getDeclaredFields()[0].getName()
					+ ":" + o.toString());
	}
	
	public void classNameTest(String str){
		System.out.println("className:"+this.getClass().getName()+",param:"+str);
	}
}
class Test01{  
	static  void fun(){ 
		//Java 获取调用方法的调用类及调用类的上级调用方法或类
		StackTraceElement stack[] = Thread.currentThread().getStackTrace();  
//		StackTraceElement stack[] = (new Throwable()).getStackTrace();  //或
		for (int i = 0; i < stack.length; i++) {  
		    StackTraceElement ste = stack[i];  
		    System.out.println(ste.getClassName() + "." + ste.getMethodName() + "(...)");  
		    System.out.println(i+"--"+ste.getMethodName()+"--"+ste.getFileName() + "--" + ste.getLineNumber());  
		}
		try {
			System.out.println(Class.forName(Thread.currentThread().getStackTrace()[2].getClassName()).getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  
  }