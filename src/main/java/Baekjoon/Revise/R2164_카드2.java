package Baekjoon.Revise;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class R2164_카드2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <=N; i++) {
			queue.add(i);
		}

		while (queue.size() != 1) {
			queue.poll();
			queue.add(queue.poll());
		}

		Integer answer = queue.peek();
		System.out.println(answer);

	}
}
