package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2667_단지번호붙이기 {
	static int[][] arr;
	static boolean[][] visited;
	static int N;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}

		List<Integer> complexSizes = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					complexSizes.add(BFS(i,j));
				}
			}
		}

		Collections.sort(complexSizes);

		System.out.println(complexSizes.size());

		for (int i : complexSizes) {
			System.out.println(i);
		}
	}
	private static int BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{i, j});
		visited[i][j] = true;
		int count = 1;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int cx = current[0], cy = current[1];

			for (int q = 0; q < 4; q++) {
				int nx = cx + dx[q];
				int ny = cy + dy[q];

				if (nx >=0 && ny >= 0 && nx < N && ny < N) {
					if (arr[nx][ny] == 1 && !visited[nx][ny]) {
						queue.add(new int[]{nx, ny});
						visited[nx][ny] = true;
						count++;
					}
				}
			}
		}
		return count;
	}
}
