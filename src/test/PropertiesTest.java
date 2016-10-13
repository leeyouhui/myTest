package test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertiesTest {

//	1
	private static ResourceBundle rb = ResourceBundle.getBundle("test/a");
	private static String name;
	private static String[] cname;
	private static Properties p = new Properties();
	static{
		try {
			long start = System.currentTimeMillis();
//			2
//			p.load(new FileInputStream("src/test/a.properties"));
			p.load(new BufferedInputStream(new FileInputStream("src/test/a.properties")));
			System.out.println(System.currentTimeMillis() - start+"ms");
			
//			3
			Configuration config = new PropertiesConfiguration("src/test/a.properties");
			//mq
			name = config.getString("name");//只返回第一个逗号前的
			cname = config.getStringArray("name");//返回一个以逗号为分隔的数组
		} catch (Exception e) {} 
	}
	
	public static void main(String[] args) {
		System.out.println("ResourceBundle: "+rb.getString("name"));
		System.out.println("Configuration: "+name);
		System.out.println("Configuration: "+Arrays.toString(cname));
		System.out.println("Properties: "+p.getProperty("name"));
	}

}
