package Baekjoon.Revise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1325_효율적인_해킹 {
	static ArrayList<Integer>[] arr;
	static int[] impact;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		impact = new int[N + 1];
		arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int end = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			arr[start].add(end);
		}

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			BFS(i);
		}

		int maxImpact = 0;
		for (int i = 1; i <= N; i++) {
			if (maxImpact < impact[i]) {
				maxImpact = impact[i];
			}
		}

		for (int i = 1; i <= N; i++) {
			if (maxImpact == impact[i]) {
				bw.write(i + " ");
			}
		}
		bw.flush();
		bw.close();
	}

	private static void BFS(int i) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		visited[i] = true;
		impact[i]++;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int computer : arr[current]) {
				if (!visited[computer]) {
					visited[computer] = true;
					queue.add(computer);
					impact[i]++;
				}
			}
		}
	}
}
