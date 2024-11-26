package Baekjoon.Revise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S18352_특정_거리의_도시_찾기 {
	static boolean[] visited;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		visited = new boolean[N+1];


		for (int i = 0; i < M; i ++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			arr[start].add(end);
		}

		List<Integer> result = bfs(K,X);

		if (result.isEmpty()) {
			System.out.println(-1);
		} else {
			Collections.sort(result);
			for (int city : result) {
				System.out.println(city);
			}
		}

	}

	private static List<Integer> bfs(int K, int X) {
		Queue<Integer> queue = new LinkedList<>();
		int[] distance = new int[arr.length];
		Arrays.fill(distance,-1);
		distance[X] = 0;
		queue.add(X);

		List<Integer> result = new ArrayList<>();

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i : arr[current]) {
				if (distance[i] == -1) {
					distance[i] = distance[current] + 1;
					queue.add(i);

					if (distance[i] == K) {
						result.add(i);
					}
				}
			}
		}
		return result;


	}
}
