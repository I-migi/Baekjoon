package Baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class S18352_특정_거리의_도시_찾기 {
	static int visited[];
	static ArrayList<Integer>[] A;
	static int N,M,K,X;
	static List<Integer> answer;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int X = sc.nextInt();

		A = new ArrayList[N+1];
		answer = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			// A 배열 안에 [] 하나씩 넣기
			A[i] = new ArrayList<Integer>();
		}

		for (int i =0; i < M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			A[S].add(E);
		}

		visited = new int[N+1];
		for (int i =0; i<=N; i++) {
			visited[i] = -1;
		}

		BFS(X);
		for (int i =0; i<=N; i++) {
			if (visited[i] == K) {
				answer.add(i);
			}
		}

		if (answer.isEmpty()) {
			System.out.println("-1");
		}
		else {
			Collections.sort(answer);
			for (int i : answer) {
				System.out.println(i);
			}
		}
	}

	private static void BFS(int Node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Node);
		visited[Node]++;
		while (!queue.isEmpty()) {
			int now_Node = queue.poll();
			for (int i: A[now_Node]) {
				if (visited[i] == -1) {
					visited[i] = visited[now_Node] + 1;
					queue.add(i);
				}
			}
		}
	}

}
