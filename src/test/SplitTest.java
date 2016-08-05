package test;

public class SplitTest {

	public static String url = "10.125.3.11:7000;10.125.3.21:7000:7000;10.125.3.31:7000;";
	public static void main(String[] args) {
		String[] strs = url.split(";|:|\\.");
		for (String str : strs)
			System.out.println(str);
	}

}
