package Baekjoon.Revise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class R1427_소트인사이드 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();

		char[] arr = N.toCharArray();
		Arrays.sort(arr);

		char[] arr2 = new char[N.length()];

		for (int i = N.length() - 1; i >= 0; i--) {
			arr2[i] = arr[N.length() - i - 1];
		}

		String answer = "";
		for (int i =0; i<arr2.length; i++) {
			answer = answer + arr2[i];
		}

		System.out.println(answer);

	}

}
