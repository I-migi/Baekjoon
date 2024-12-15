package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S14888_연산자_끼워넣기 {
	static int[] arr;
	static int[] operator = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		backtrack(arr[0], 1);

		System.out.println(max);
		System.out.println(min);

	}

	static void backtrack(int current, int index) {

		if (index == arr.length) {
			max = Math.max(max, current);
			min = Math.min(min, current);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;

				switch (i) {
					case 0:
						backtrack(current + arr[index], index + 1);
						break;
					case 1:
						backtrack(current - arr[index], index + 1);
						break;
					case 2:
						backtrack(current * arr[index], index + 1);
						break;
					case 3:
						backtrack(current / arr[index], index + 1);
						break;
				}
				operator[i]++;

			}
		}
	}
}