package Baekjoon.Gold;

import java.io.IOException;
import java.util.Scanner;

public class G1747_소수_팰린드롬 {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num = N;

		while (true) {
			if (isPrime(num) && isDrome(num)) {
				System.out.println(num);
				break;
			}
			num++;
		}
	}

	private static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static boolean isDrome(int num) {
		String number = String.valueOf(num);

		for (int i = 0; i < number.length() /2; i++) {
			if (number.charAt(i) != number.charAt(number.length() - i - 1)) {
				return false;
			}
		}
		return true;



	}
}
