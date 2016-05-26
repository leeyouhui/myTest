package test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesTest {

	private static ResourceBundle rb = ResourceBundle.getBundle("test/a");
	private static String name = rb.getString("name");
	private static Properties p = new Properties();
	static{
		try {
			long start = System.currentTimeMillis();
//			p.load(new FileInputStream("src/test/a.properties"));
			p.load(new BufferedInputStream(new FileInputStream("src/test/a.properties")));
			System.out.println(System.currentTimeMillis() - start+"ms");
		} catch (Exception e) {} 
	}
	
	public static void main(String[] args) {
		System.out.println(rb.getString("name"));
		System.out.println(name);
		System.out.println(p.getProperty("name"));
	}

}
