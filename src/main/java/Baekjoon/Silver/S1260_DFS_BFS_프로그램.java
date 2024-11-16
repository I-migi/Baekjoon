package Baekjoon.Silver;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1260_DFS_BFS_프로그램 {
	static ArrayList<Integer>[] A;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		A = new ArrayList[N + 1];
		for (int i =1; i<=N; i++) {
			A[i] = new ArrayList<Integer>();
		}

		for (int i =0; i<M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			A[S].add(E);
			A[E].add(S);
		}

		for (int i =1; i<=N; i++){
			Collections.sort(A[i]);
		}
		visited = new boolean[N + 1];
		DFS(V);
		System.out.println();
		visited = new boolean[N + 1];
		BFS(V);
		System.out.println();
	}

	// DFS 는 재귀로 구하기
	private static void DFS(int V) {
		System.out.print(V + " ");
		visited[V] = true;
		for (int i : A[V]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
	}

	// BFS 는 Queue 를 사용해서 구하기
	private static void BFS(int V) {
		Queue<Integer> queue = new LinkedList<Integer>();
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
