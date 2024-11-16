package Baekjoon.Revise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class R11399_ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];

		for (int i =0; i< N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int[] sumArr = new int[N];
		sumArr[0] = arr[0];
		for (int i =1; i<N; i++) {
			sumArr[i] = sumArr[i-1] + arr[i];
		}
		int sum = 0;

		for (int i =0; i<N; i++) {
			sum = sum + sumArr[i];
		}
		System.out.println(sum);
	}
}
