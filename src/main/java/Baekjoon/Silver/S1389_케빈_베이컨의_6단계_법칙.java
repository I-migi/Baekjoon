package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1389_케빈_베이컨의_6단계_법칙 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] arr = new ArrayList[N+1];
		for (int i =1; i<=N; i++) {
			arr[i] =  new ArrayList<>();
		}

		for (int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}

		int minKevinBacon = Integer.MAX_VALUE;
		int result = -1;

		for (int i =1; i<=N; i++) {
			int kevinBacon = bfs(i, N, arr);
			if (kevinBacon < minKevinBacon) {
				minKevinBacon = kevinBacon;
				result = i;
			}
		}

		System.out.println(result);

	}

	private static int bfs(int start, int N, ArrayList<Integer>[] arr) {

		int[] distances = new int[N+1];
		Arrays.fill(distances, -1);
		distances[start] = 0;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int neighbor : arr[current]) {
				if (distances[neighbor] == -1) {
					distances[neighbor] = distances[current] + 1;
					queue.add(neighbor);
				}
			}
		}

		int totalDistance = 0;
		for (int i = 1; i<=N; i++) {
			totalDistance += distances[i];
		}
		return totalDistance;

	}
}
