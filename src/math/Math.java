package math;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Math {

	public static void main(String[] args) {
		System.out.println(2 ^ 3);// 异或=1
		List<String> l = new ArrayList<String>();
		l.add("aa");
		l.add("bb");
		l.add("cc");
		Iterator<String> it = l.iterator();
		while(it.hasNext()){
			if(it.next().equals("bb")){
				it.remove();
			}
		}
//		it = l.iterator();
		/*while(it.hasNext()){
			System.out.println(it.next());
		}
		for(String s:l){
			System.out.println(s);
		}*/
		
		List<String> l2 = new ArrayList<String>();
		l2.add("aa");
		l2.add("bb");
		l2.add("cc");
		l2.add("aa");
		/*for(String s:l2){
			for(String s1:l2){
				if(s.equals(s1)){
					l2.remove(s1);
				}
			}
			
		}*/
		
		it = l2.iterator();
//		while(it.hasNext()){
//			for(String s1:l2){
//				if(it.next().equals(s1)){
//					l2.remove(s1);
//				}
//			}
//			
//		}
		l.addAll(l2);
		int step = 0;
		/*while(it.hasNext()){
			String s1 = it.next();
			it.remove();
			while(it.hasNext()){
				if(s1.equals(it.next())){
					it.remove();
				}
			}
			it = l2.iterator();
			step++;
		}*/
		
		while(l2.size()>0){
			String s1 = l2.get(0);
			l2.remove(0);
			for(int j=0;j<l2.size();j++){
				if(s1.equals(l2.get(j))){
					l2.remove(j);
					j--;
				}
			}
			step++;
		}
		
		for(String s:l2){
			System.out.println(s);
		}
		System.out.println(step);
		
		Random random = new Random();
		int nextInt = random.nextInt(10) + 1;
		System.out.println(nextInt);
	}

}
