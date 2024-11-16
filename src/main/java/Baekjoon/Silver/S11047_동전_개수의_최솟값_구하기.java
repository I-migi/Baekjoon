package Baekjoon.Silver;

import java.util.Scanner;

public class S11047_동전_개수의_최솟값_구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] A = new int[N];
		int count = 0;

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		for (int i = N-1; i >=0; i--) {
			if (A[i] <= K) {
				count = count + K/A[i];
				K = K % A[i];
			}
		}
		System.out.println(count);
	}
}
