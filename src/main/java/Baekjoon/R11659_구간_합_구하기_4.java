package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class R11659_구간_합_구하기_4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int arr[] = new int[N+1];

		st = new StringTokenizer(br.readLine());
		for (int i =0; i<N; i++) {
			arr[i+1] = Integer.parseInt(st.nextToken());
		}

		int sumArr[] = new int[N+1];

		int sum = 0;
		for (int i=0; i< N+1; i++) {
			sum = sum + arr[i];
			sumArr[i] = sum;
		}

		for (int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			System.out.println(sumArr[E] - sumArr[S - 1]);
		}
	}
}
