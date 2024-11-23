package Baekjoon.Silver;

import java.util.Scanner;

public class S2193_이친수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		long[][] D = new long[N+1][2];
		D[1][0] = 0;
		D[1][1] = 1;


		for (int i= 2; i <= N; i++) {
			D[i][0] = D[i-1][0] + D[i-1][1];
			D[i][1] = D[i-1][0];
		}

		System.out.println(D[N][1] + D[N][0]);
	}
}
