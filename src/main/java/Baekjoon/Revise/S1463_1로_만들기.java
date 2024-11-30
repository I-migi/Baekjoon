package Baekjoon.Revise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1463_1로_만들기 {
	static int answer;
	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		answer = 0;

		System.out.println(BFS(N));
	}

	private static int BFS(int N) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		queue.add(N);
		visited[N] = true;
		int answer = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int current = queue.poll();

				if (current == 1) {
					return answer;
				}
				if (current % 3 == 0 && !visited[current/3]) {
					queue.add(current /3);
					visited[current/3] = true;
				}
				if (current % 2 == 0 && !visited[current/2]) {
					queue.add(current / 2);
					visited[current/2] = true;
				}

				if (current -1 > 0 && !visited[current - 1]) {
					queue.add(current - 1);
					visited[current - 1] = true;
				}
			}
			answer++;
		}

		return answer;
	}
}
