package Baekjoon.Revise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S13251_조약돌_꺼내기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = 0;
		for (int i = 0; i < M; i++) {
			N = N + arr[i];
		}

		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + combination(arr[i], K) / combination(N,K);
		}

		System.out.println(sum);
	}

	private static double combination(int n, int k) {

		if (k > n) return 0.0;
		double result = 1.0;
		for (int i = 0; i < k; i++) {
			result = result * (n-i);
			result = result / (i+1);
		}
		return result;

	}
}
