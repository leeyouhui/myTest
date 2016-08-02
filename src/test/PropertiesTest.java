package test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertiesTest {

//	1
	private static ResourceBundle rb = ResourceBundle.getBundle("test/a");
	private static String name = rb.getString("name");
	private static Properties p = new Properties();
	static{
		try {
			long start = System.currentTimeMillis();
//			2
//			p.load(new FileInputStream("src/test/a.properties"));
			p.load(new BufferedInputStream(new FileInputStream("src/test/a.properties")));
			System.out.println(System.currentTimeMillis() - start+"ms");
			
//			3
			Configuration config = new PropertiesConfiguration(StringUtils.getRealPath() + "/config/config.properties");
			//mq
			name = config.getString("name");
		} catch (Exception e) {} 
	}
	
	public static void main(String[] args) {
		System.out.println(rb.getString("name"));
		System.out.println(name);
		System.out.println(p.getProperty("name"));
	}

}
