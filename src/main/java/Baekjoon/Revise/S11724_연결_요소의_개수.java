package Baekjoon.Revise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S11724_연결_요소의_개수 {
	static boolean[] visited;
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			arr[u].add(v);
			arr[v].add(u);
		}

		visited = new boolean[n + 1];
		int answer = 0;

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				answer++;
				DFS(i);
			}
		}

		System.out.println(answer);
	}

	private static void DFS(int v) {
		visited[v] = true;

		for (int next : arr[v]) {
			if (!visited[next]) {
				DFS(next);
			}
		}
	}
}
