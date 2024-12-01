package Baekjoon.Revise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S11725_트리의_부모_찾기 {
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a].add(b);
			arr[b].add(a);
		}

		visited = new boolean[N+1];
		parents = new int[N+1];

		BFS(1);


		for (int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
	}

	private static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(v);
		visited[v] = true;
		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i : arr[current]) {
				if (!visited[i]) {
					visited[i] = true;
					parents[i] = current;
					queue.add(i);
				}
			}
		}
	}
}
