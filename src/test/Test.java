package test;

public class Test {
	public byte[] protoBody;

	public static void main(String[] args) {
		Test test = new Test();
		System.err.println(test.protoBody==null);
		int i = Integer.MAX_VALUE;
		System.err.println("i = "+i);
		System.err.println("i+1 = "+(i+2146483649+1000000));
		i = (int) System.currentTimeMillis();
		System.err.println("i = "+i);
	}

}
