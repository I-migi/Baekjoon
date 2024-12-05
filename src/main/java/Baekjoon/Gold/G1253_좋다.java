package Baekjoon.Gold;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class G1253_좋다 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			int start = 0;
			int end = arr.length - 1;

			while (start < end) {
				if (start == i) {
					start++;
					continue;
				}
				if (end == i) {
					end--;
					continue;
				}

				int sum = arr[start] + arr[end];

				if (sum == arr[i]) {
					count++;
					break;
				} else if (sum < arr[i]) {
					start++;
				} else {
					end--;
				}
			}
		}

		System.out.println(count);
	}
}
