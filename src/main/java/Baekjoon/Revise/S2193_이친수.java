package Baekjoon.Revise;

import java.util.Scanner;

public class S2193_이친수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		long[] D = new long[91];
		D[1] = 1;
		D[2] = 1;

		for (int i = 3; i < D.length; i++) {
			D[i] = D[i-1] + D[i-2];
		}

		System.out.println(D[N]);
	}
}
