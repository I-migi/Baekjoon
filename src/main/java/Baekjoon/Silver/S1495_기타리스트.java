package Baekjoon.Silver;

import java.util.Scanner;

public class S1495_기타리스트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();
        int[] V = new int[N];

        for (int i = 0; i < N; i++) {
            V[i] = sc.nextInt();
        }

        boolean[][] DP = new boolean[N+1][M+1];
        DP[0][S] = true;

        for (int i = 1; i <= N; i++) {
            for (int v = 0; v <=M; v++) {
                if (DP[i-1][v]) {
                    if (v - V[i-1] >= 0) {
                        DP[i][v - V[i-1]] = true;
                    }
                    if (v + V[i-1] <= M) {
                        DP[i][v + V[i-1]] = true;
                    }
                }
            }
        }

        int answer = -1;
        for (int v = 0; v <= M; v++ ) {
            if (DP[N][v]) {
                answer = v;
            }
        }

        System.out.println(answer);
    }
}
