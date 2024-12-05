package Baekjoon.Revise;

import java.util.Scanner;

public class S2018_수들의_합_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int count = 0;
		int start = 1;
		int end = 1;
		int sum = 1;

		while (start <= N) {
			if (sum == N) {
				count ++;
				sum = sum - start;
				start++;
			} else if (sum < N) {
				end ++;
				sum = sum + end;
			} else {
				sum = sum - start;
				start++;
			}
		}

		System.out.println(count);


	}
}
