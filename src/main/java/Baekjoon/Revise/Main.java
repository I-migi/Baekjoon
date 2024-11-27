package Baekjoon.Revise;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String problem = scanner.nextLine();

		String[] split = problem.split("-");

		int first = addSplit(split[0]);

		for (int i = 1; i < split.length; i++) {
			int second = addSplit(split[i]);
			first = first - second;
		}

		System.out.println(first);

	}

	private static int addSplit(String problem) {
		String[] split = problem.split("\\+");
		int sum = 0;
		for (int i = 0; i < split.length; i++) {
			sum = sum + Integer.parseInt(split[i]);
		}
		return sum;

	}
}
