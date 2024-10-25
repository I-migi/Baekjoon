package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS11724 {

	static ArrayList<Integer>[] A;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {



		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		A = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i =1; i<n +1; i++) {
			A[i] = new ArrayList<>();
		}

		for (int i=0; i<m;  i++) {
			st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
            A[v].add(u);
		}
		int count = 0;
		for (int i=1; i< n+1; i++) {
			if (!visited[i]) {
				count++;
				DFS(i);
			}
		}
		System.out.println(count);
	}

	static void DFS(int start) {
		if (visited[start]) {
			return;
		}
		visited[start] = true;
		for (int i : A[start]) {
			DFS(i);
		}
	}

}