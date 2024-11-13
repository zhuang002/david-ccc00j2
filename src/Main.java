import java.util.Scanner;

public class Main {

	static int[] dic = new int[10];
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
				System.out.println(n);
			}
		}
		System.out.println(count);
	}

	private static void intializeDictionary() {
		// TODO Auto-generated method stub
		for (int i=0;i<10;i++) {
			dic[i] = -1;
		}
		
		dic[0] = 0;
		dic[1] = 1;
		dic[6] = 9;
		dic[8] = 8;
		dic[9] = 6;
	}

	private static boolean isRotatable(int n) {
		// using string to identify;
		String original = Integer.toString(n);
		String rotated = "";
		for (int i=0;i<original.length();i++) {
			char c = original.charAt(i);
			int digit = c - '0';
			int rotatedDigit = dic[digit];
			
			if (rotatedDigit == -1) {
				return false;
			}
			
			char rotatedChar = (char)('0' + rotatedDigit);
			rotated = rotatedChar + rotated;
		}
		
		return rotated.equals(original);
		
	}

}
