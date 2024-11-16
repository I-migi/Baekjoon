package Baekjoon;

import java.util.Scanner;

public class R1546_평균 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[] arr = new double[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		double M = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] > M) {
				M = arr[i];
			}
		}

		for (int i = 0; i < N; i++) {
			arr[i] = arr[i]/M * 100;
		}

		double sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
		}
		System.out.println(sum / N);
	}
}
