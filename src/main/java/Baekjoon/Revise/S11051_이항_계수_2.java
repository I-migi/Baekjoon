package Baekjoon.Revise;

import java.util.Scanner;

public class S11051_이항_계수_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		double result = 1;

		for (int i = 0; i <K; i++) {
			result = result * (N-i);
			result = result / (i+1);
		}

		System.out.println(result % 10007);
	}
}
