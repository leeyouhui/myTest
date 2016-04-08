package lambda;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator calculator = (num) -> 1 + num;
		int[] result = map(new int[]{1, 2, 3, 4}, calculator);
		for(int i = 0; i<result.length;i++){
			
			System.out.println(result[i]);
		}
	}
	
	public static int[] map(int[] numArr, Calculator calculator) {
	    int[] result = new int[numArr.length];
	    for (int i = 0; i < numArr.length; i++) {
	        result[i] = calculator.calc(numArr[i]);
	    }
	    return result;
	}
}
