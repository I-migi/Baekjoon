package Baekjoon.Revise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2775_부녀회장이_될테야 {
	public static void main(String[] args) throws IOException {

		int[][] D = new int[15][15];

		for (int i = 0; i < 15; i++) {
			D[i][1] = 1;
			D[0][i] = i;
		}

		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				D[i][j] = D[i][j-1] + D[i-1][j];
			}
		}



		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			System.out.println(D[a][b]);


		}
	}
}
