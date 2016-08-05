package test;

public class StaticTest {
	
	private static String str = null;
	static{
		str = "123";
		System.out.println(str);
		System.out.println(initStr());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static String initStr(){
		str = "456";
		return str;
	}
}
