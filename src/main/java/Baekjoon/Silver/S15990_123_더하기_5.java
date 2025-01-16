package Baekjoon.Silver;

import java.util.Scanner;

public class S15990_123_더하기_5 {
    static final int MOD = 1000000009;
    static long[][] DP;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int maxN = 0;
        int[] testCases = new int[T];
        for (int i = 0; i < T; i++) {
            testCases[i] = sc.nextInt();
            maxN = Math.max(maxN, testCases[i]);
        }

        // DP 배열 초기화
        DP = new long[maxN + 1][4];
        if (maxN >= 1) {
            DP[1][1] = 1;
            DP[1][2] = 0;
            DP[1][3] = 0;
        }
        if (maxN >= 2) {
            DP[2][1] = 0;
            DP[2][2] = 1;
            DP[2][3] = 0;
        }
        if (maxN >= 3) {
            DP[3][1] = 1;
            DP[3][2] = 1;
            DP[3][3] = 1;
        }

        // DP 배열 채우기
        for (int j = 4; j <= maxN; j++) {
            DP[j][1] = (DP[j - 1][2] + DP[j - 1][3]) % MOD;
            DP[j][2] = (DP[j - 2][1] + DP[j - 2][3]) % MOD;
            DP[j][3] = (DP[j - 3][1] + DP[j - 3][2]) % MOD;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int N : testCases) {
            long answer = (DP[N][1] + DP[N][2] + DP[N][3]) % MOD;
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}