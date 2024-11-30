package Baekjoon.Revise;

import java.util.Scanner;

public class S11726_2_x_타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] D = new int[1001];

		D[1] = 1;
		D[2] = 2;

		for (int i = 3; i <= 1000; i++) {
			D[i] = (D[i-1] + D[i-2]) % 10007;
		}

		System.out.println(D[N]);
	}
}
