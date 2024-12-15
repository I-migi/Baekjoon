package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2156_포도주_시식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		if (N==1) {
			System.out.println(Integer.parseInt(br.readLine()));
			return;
		}

		int[] arr = new int[N + 1];
		int[] D = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		D[1] = arr[1];
		if (N >1) {
			D[2] = arr[1] + arr[2];
		}

		for (int i = 3; i <= N; i++) {
			D[i] = Math.max(D[i-1],Math.max(D[i-2]+arr[i], D[i-3] + arr[i-1] + arr[i]));
		}

		System.out.println(D[N]);
	}
}
