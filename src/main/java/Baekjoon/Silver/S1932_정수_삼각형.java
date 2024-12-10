package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1932_정수_삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		int N = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][];


		for (int i = 0; i < N; i++) {
			arr[i] = new int[i+1];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] DP = new int[N][];
		DP[0] = new int[1];

		DP[0][0] = arr[0][0];

		for (int i = 1; i < N; i++) {
			DP[i] = new int[i +1];
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					DP[i][j] = arr[i][j] + DP[i-1][0];
				} else if (j == i) {
					DP[i][j] = arr[i][j] + DP[i-1][j];
				} else
					DP[i][j] = arr[i][j] + Math.max(DP[i-1][j-1], DP[i-1][j]);
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, DP[N-1][i]);
		}

		System.out.println(max);

	}
}
