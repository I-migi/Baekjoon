package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S14889_스타트와_링크 {
	static int[][] arr;
	static int N;
	static int minDifference = Integer.MAX_VALUE;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		arrangeTeam(0,0);
		System.out.println(minDifference);
	}

	static void arrangeTeam(int size, int start) {
		if (size == N/2) {
			calculateDifference();
			return;
		}

		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arrangeTeam(size + 1, i + 1);
				visited[i] = false;
			}
		}
	}

	static void calculateDifference() {
		int startSum = 0 , linkSum = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i] && visited[j]) {
					startSum += arr[i][j];
				} else if (!visited[i] && !visited[j]) {
					linkSum += arr[i][j];
				}
			}
		}

		minDifference = Math.min(minDifference, Math.abs(startSum - linkSum));

	}

}
