package Baekjoon.Silver;

import java.util.Scanner;

public class S1934_최소_공배수_구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i =0; i< T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int result = a * b /gcd(a,b);

			System.out.println(result);
		}
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
}
