package Baekjoon.Revise;

import java.util.PriorityQueue;
import java.util.Scanner;

public class S11286_절댓값_힙 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();

		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
			int absA = Math.abs(a);
			int absB = Math.abs(b);
			if (absA == absB) {
				return a -b;
			}
			return absA - absB;
		});

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();

			if (x == 0) {
				if (pq.isEmpty()) {
					System.out.println("0\n");
				} else {
					System.out.println(pq.poll()+"\n");
				}
			} else {
				pq.add(x);
			}

		}
	}
}
