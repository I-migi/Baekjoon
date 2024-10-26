package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1940_주몽의명령 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;
		int N = Integer.parseInt(bufferedReader.readLine());
		int M = Integer.parseInt(bufferedReader.readLine());
		int[] arr = new int[N];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stringTokenizer.nextToken());
		}
		Arrays.sort(arr);

		int firstIndex = 0;
		int secondIndex = N - 1;
		int count = 0;

		while (firstIndex < secondIndex) {
			int sum = arr[firstIndex] + arr[secondIndex];

			if (sum > M) {
				secondIndex--;
			} else if (sum == M) {
				count++;
				firstIndex++;
				secondIndex--;
			} else {
				firstIndex++;
			}
		}
		System.out.println(count);
	}
}
