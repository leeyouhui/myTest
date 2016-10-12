package test;

import java.util.HashMap;

public class A {
	
	private static HashMap<String, String> amap = new HashMap<>();
	
	static{
		amap.put("a", "this  is a !");
	}

	public static HashMap<String, String> getAmap() {
		return amap;
	}

	public static void setAmap(HashMap<String, String> amap) {
		A.amap = amap;
	}



}
