package Baekjoon.Revise;

import java.util.HashSet;
import java.util.Scanner;

public class S14425_문자열_집합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();

		HashSet<String> hash = new HashSet<>();

		for (int i = 0; i < N; i++) {
			hash.add(sc.nextLine());
		}
		int count = 0;
		for (int i = 0; i < M; i++) {
			if (hash.contains(sc.nextLine())) {
				count++;
			}
		}

		System.out.println(count);
	}
}
