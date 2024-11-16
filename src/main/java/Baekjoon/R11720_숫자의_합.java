package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class R11720_숫자의_합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		String M = br.readLine();

		int sum = 0;
		for (int i =0; i<N; i++) {
			sum = sum + Integer.parseInt(String.valueOf(M.charAt(i)));
		}
		System.out.println(sum);
	}
}
