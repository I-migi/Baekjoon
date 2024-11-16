package Baekjoon.Revise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class R1260_DFS와_BFS {
	static boolean visited[];
	static ArrayList<Integer>[] A;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		A = new ArrayList[N+1];

		for (int i =1; i<=N; i++) {
			A[i] = new ArrayList<>();
		}

		for(int i = 1; i<=M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			A[a].add(b);
			A[b].add(a);
		}

		for (int i = 1; i<=N; i++) {
			Collections.sort(A[i]);
		}

		visited = new boolean[N+1];
		DFS(V);
		System.out.println();
		visited = new boolean[N+1];
		BFS(V);
	}
	private static void DFS(int V) {
		visited[V] = true;
		System.out.print(V + " ");
		for (int i : A[V]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
	}

	private static void BFS(int V) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		visited[V] = true;

		while (!queue.isEmpty()) {
			int currentV = queue.poll();
			System.out.print(currentV + " ");

			for (int i : A[currentV]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
