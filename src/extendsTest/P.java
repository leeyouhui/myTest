package extendsTest;

public class P {
	private static String pa;
	static {
		pa = "12345";
	}
	
	public void printPa(){
		System.out.println("-----P----:pa="+pa);
	}
	
}
