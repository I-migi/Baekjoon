package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S9465_스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());

		for (int t = 0; t < testCases; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][N];
			int[][] DP = new int[N][3];


			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}


			DP[0][0] = arr[0][0];
			DP[0][1] = arr[1][0];
			DP[0][2] = 0;


			for (int i = 1; i < N; i++) {
				DP[i][0] = arr[0][i] + Math.max(DP[i - 1][1], DP[i - 1][2]);
				DP[i][1] = arr[1][i] + Math.max(DP[i - 1][0], DP[i - 1][2]);
				DP[i][2] = Math.max(DP[i - 1][0], Math.max(DP[i - 1][1], DP[i - 1][2]));
			}


			System.out.println(Math.max(DP[N - 1][0], Math.max(DP[N - 1][1], DP[N - 1][2])));
		}
	}
}
