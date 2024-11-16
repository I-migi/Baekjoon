package Baekjoon.Revise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class R1940_주몽 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int count = 0;
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if (arr[i] + arr[j] == M)
					count ++;
			}
		}
		System.out.println(count);
	}
}
