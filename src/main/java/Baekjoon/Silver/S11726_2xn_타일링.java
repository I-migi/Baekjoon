package Baekjoon.Silver;

import java.util.Scanner;

public class S11726_2xn_타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		long[] D = new long[1001];

		D[1] = 1;
		D[2] = 2;

		for (int i = 3; i <= N; i++) {
			D[i] = (D[i-1] + D[i-2]) % 10007;
		}
		System.out.println(D[N]);
	}
}
