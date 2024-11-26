package Baekjoon.Revise;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S11047_동전_0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] moneys = new int[N];

		for (int i = 0; i < N; i++) {
			moneys[i] = Integer.parseInt(br.readLine());
		}

		int answer = 0;

		for (int i = N - 1; i >= 0; i--) {
			if (moneys[i] <= K) {
				answer += K / moneys[i];
				K %= moneys[i];
			}
		}

		System.out.println(answer);
	}
}