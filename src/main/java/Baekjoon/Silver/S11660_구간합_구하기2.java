package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S11660_구간합_구하기2 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());

		int[][] A = getArrage(N, bufferedReader);

		int[][] D = getRangePlus(N, A);

		getResult(M, bufferedReader, D);

	}

	private static int[][] getArrage(int N, BufferedReader bufferedReader) throws IOException {
		StringTokenizer stringTokenizer;
		int A[][] = new int[N +1][N +1];
		for (int i = 1; i<= N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 1; j<= N; j++) {
				A[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}
		return A;
	}

	private static int[][] getRangePlus(int N, int[][] A) {
		int D[][] = new int[N +1][N +1];
		for (int i = 1; i<= N; i++) {
			for (int j = 1; j<= N; j++) {
				D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
			}
		}
		return D;
	}

	private static void getResult(int M, BufferedReader bufferedReader, int[][] D) throws IOException {
		StringTokenizer stringTokenizer;
		for (int i = 0; i< M; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int x1 = Integer.parseInt(stringTokenizer.nextToken());
			int y1 = Integer.parseInt(stringTokenizer.nextToken());
			int x2 = Integer.parseInt(stringTokenizer.nextToken());
			int y2 = Integer.parseInt(stringTokenizer.nextToken());

			int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
			System.out.println(result);
		}
	}
}