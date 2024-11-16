package Baekjoon.Silver;

import java.util.Arrays;
import java.util.Scanner;

public class S1931_회의실_배정하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] A = new int[N][2];

		for (int i =0; i<N; i++) {
			A[i][0] = sc.nextInt();
			A[i][1] = sc.nextInt();
		}

		Arrays.sort(A, (m1, m2) -> {
			if (m1[1] == m2[1]) {
				return m1[0] - m2[0];
			}
			return m1[1] - m2[1];
		});

		int count = 0;
		int end = -1;
		for (int i =0; i< N; i++) {
			if (A[i][0] >= end) {
				end = A[i][1];
				count++;
			}
		}
		System.out.println(count);

	}
}
