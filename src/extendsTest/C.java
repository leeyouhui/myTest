package extendsTest;

public class C extends P {
	public C(){
		System.out.println("init C");
	}
	public void cMethod(){
		System.out.println("-----C----");
		printPa();
	}
}
