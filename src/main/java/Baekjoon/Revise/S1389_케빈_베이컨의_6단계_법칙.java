package Baekjoon.Revise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1389_케빈_베이컨의_6단계_법칙 {
	static ArrayList<Integer>[] arr;
	static int[] arr2;
	static boolean[] visited;
	static int[] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N+1];
		arr2 = new int[N+1];

		for (int i = 1; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			arr2[i] = BFS(i);
		}

		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			min = Math.min(min, arr2[i]);
		}

		for (int i = 1; i <= N; i++) {
			if (arr2[i] == min) {
				System.out.print(i);
				break;
			}
		}



	}

	private static int BFS(int i) {
		Queue<Integer> queue = new LinkedList<>();
		distance = new int[arr.length];
		visited = new boolean[arr.length];

		queue.add(i);
		visited[i] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int neighbor : arr[current]) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					distance[neighbor] = distance[current] + 1;
					queue.add(neighbor);
				}
			}
		}

		int totalDistance = 0;
		for (int d : distance) {
			totalDistance += d;
		}

		return totalDistance;
	}
}
