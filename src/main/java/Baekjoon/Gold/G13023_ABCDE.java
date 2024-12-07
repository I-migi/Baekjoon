package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G13023_ABCDE {
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a].add(b);
			arr[b].add(a);
		}
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (DFS(i,0)) {
				System.out.println("1");
				return;
			}
		}
		System.out.println("0");
	}

	private static boolean DFS(int i, int depth) {
		if (depth == 4) {
			return true;
		}
		visited[i] = true;

		for (int j : arr[i]) {
			if (!visited[j]) {
				if (DFS(j, depth +1)) {
					return true;
				}
			}
		}
		visited[i] = false;
		return false;


	}
}
