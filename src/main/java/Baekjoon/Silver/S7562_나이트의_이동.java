package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S7562_나이트의_이동 {
	static int[][] moves = {{1,2}, {2,1},{1,-2},{2,-1},{-1,2},{-2,1},{-1,-2},{-2,-1}};
	static boolean[][] visited;
	static int I;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			I = Integer.parseInt(br.readLine());
			visited = new boolean[I][I];

			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());


			st = new StringTokenizer(br.readLine());
			int targetX = Integer.parseInt(st.nextToken());
			int targetY = Integer.parseInt(st.nextToken());

			if (startX == targetX && startY == targetY) {
				sb.append(0).append("\n");
				continue;
			}

			int result = BFS(startX, startY, targetX, targetY);
			sb.append(result).append("\n");
		}

		System.out.print(sb);

	}

	static int BFS(int startX, int startY,  int targetX, int targetY) {
		Queue<Chess> queue = new LinkedList<>();
		queue.add(new Chess(startX, startY, 0));
		visited[startX][startY] = true;

		while (!queue.isEmpty()) {
			Chess current = queue.poll();

			for (int[] move : moves) {
				int nextX = current.x + move[0];
				int nextY = current.y + move[1];

				if (isValid(nextX, nextY) && !visited[nextX][nextY]) {
					if (nextX == targetX && nextY == targetY) {
						return current.depth + 1;
					}
					visited[nextX][nextY] = true;
					queue.add(new Chess(nextX, nextY, current.depth + 1));
				}
			}
		}
		return -1;
	}

	static boolean isValid(int x, int y) {
		return x >= 0 && x < I && y >= 0 && y < I;
	}

	static class Chess {
		int x;
		int y;
		int depth;

		public Chess(int x, int y,  int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
}




