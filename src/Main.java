import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static HashMap<Integer, Integer> dic = new HashMap<>();
	
	public static void main(String[] args) {
		//using array for dictionary and using string for data;
		intializeDictionary();
		
		Scanner sc = new Scanner(System.in);
		int min = sc.nextInt();
		int max = sc.nextInt();
		
		int count = 0;
		for (int n=min;n<=max;n++) {
			if (isRotatable(n)) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static void intializeDictionary() {
		dic.put(0,0);
		dic.put(1, 1);
		dic.put(6, 9);
		dic.put(8, 8);
		dic.put(9, 6);
	}

	private static boolean isRotatable(int n) {
		// using digits of n directly.

		int rotated = rotate(n);
		return rotated == n; 
	}
	

	private static int rotate(int n) {
		/*128 ->8, 12 -> 2, 1 -> 1, 0
		-》(0+8)*10 = 80 -> (80+2)*10 = 820 -> (820+1) - 821 */
		
		int rotated = 0;
		while (n>0) {
			int lastDigit = n % 10;
			n = n /10;
			if (!dic.containsKey(lastDigit)) {
				return -1;
			}
			rotated = rotated*10 + dic.get(lastDigit);
		}
		
		return rotated;
	}

}
