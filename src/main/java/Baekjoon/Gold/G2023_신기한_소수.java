package Baekjoon.Gold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class G2023_신기한_소수 {
	static int N;
	static ArrayList<Integer> answer;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		answer = new ArrayList<>();

		int[] firstNum = {2,3,5,7};

		for (int num : firstNum) {
			DFS(num, 1);
		}

		Collections.sort(answer);

		for (int answer : answer) {
			System.out.println(answer);
		}




	}

	private static void DFS(int num, int length) {
		if (length == N) {
			answer.add(num);
			return;
		}

		for (int i = 0; i < 10; i++) {
			int nextNum = num *10 + i;
			if (isPrime(nextNum)) {
				DFS(nextNum, length+1);
			}
		}
	}

	private static boolean isPrime(int number) {

		if (number <=1) {
			return false;
		}

		if (number == 2) {
			return true;
		}

		if (number % 2 == 0) {
			return false;
		}

		for (int i = 3; i <= Math.sqrt(number); i = i+2) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}
}
