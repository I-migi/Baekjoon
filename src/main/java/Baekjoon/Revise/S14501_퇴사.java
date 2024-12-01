package Baekjoon.Revise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S14501_퇴사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] T = new int[N+1];
		int[] P = new int[N+1];
		int[] D = new int[N+2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = N; i >=1; i--) {
			if (i + T[i] -1 <= N) {
				D[i] = Math.max(D[i+1], P[i] + D[i + T[i]]);
			} else {
				D[i] = D[i+1];
			}
		}

		System.out.println(D[1]);


	}
}
