package Baekjoon.Bronze;

import java.io.IOException;
import java.util.Scanner;

public class B11050_이항계수_구하기_1 {
	static int N, K;
	static int[][] D;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		D = new int[N+1][N+1];

		for (int i =0; i<=N; i++) {
			D[i][1] = i;
			D[i][0] = 1;
			D[i][i] = 1;
		}
		for (int i = 2; i<=N; i++) {
			for (int j =1; j<i; j++) {
				D[i][j] = D[i-1][j] + D[i-1][j-1];
			}
		}

		System.out.println(D[N][K]);


	}
}
