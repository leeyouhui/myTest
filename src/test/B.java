package test;

import java.util.HashMap;

public class B {

	public static void main(String[] args) {
		HashMap<String, String> b = A.getAmap();
		b.put("b", "this is b !");
		
		System.out.println(A.getAmap().toString());
		System.out.println(b.toString());
	}

}
