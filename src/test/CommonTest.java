package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;


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
		
//		double d = (double)Math.round(0.835355555*100)/100;
//		System.out.println(d);
//		
//		Integer it = 1;
//		System.out.println(it == null);
//		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//得到本月月初 
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH)); 
		System.out.println(sdf.format(calendar.getTime()));
		//得到上个月月初 
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 1);
		System.out.println(sdf.format(calendar.getTime()));
		
		//得到上个月月末 
		calendar.roll(Calendar.DATE, -1);
		System.out.println(sdf.format(calendar.getTime()));
	}
	
	@Test
	public void  testClassNameTest(){
//		Map<String, Object> map =  new HashMap<String, Object>();
//		map.put("taxTotalAmount", 2.36084207E7);
//		map.put("orderTotalQuantity", 281382);
//		map.put("orderAmount",2.36086567E7);
//		
//		System.out.println(new BigDecimal((Double)map.get("taxTotalAmount")).toPlainString());
//		classNameTest("123");
		Test01.fun();
	}

	public void strs(Object... os) {
		for (Object o : os)
			System.out.println(o.getClass().getDeclaredFields()[0].getName()
					+ ":" + o.toString());
	}
	
	public void classNameTest(String str){
		System.out.println("className:"+this.getClass().getName()+",param:"+str);
	}
	
	@Test
	public void classCP(){
		
		BeanUtils.copyProperties("", "");
		StringUtils.isNotBlank("");
		StringUtils.isNotEmpty("");
		List<String> strs = new ArrayList<String>();
		for(String str :strs){
			
		}
	}
	
	@Test
	public void hashCode1(){
		String a = "123";
		String b = new String("123");
		System.out.println(a.hashCode() == b.hashCode());
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
			System.out.println(Thread.currentThread().getStackTrace()[2].getClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  
  }