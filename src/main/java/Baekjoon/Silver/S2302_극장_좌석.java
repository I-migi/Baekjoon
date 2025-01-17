package Baekjoon.Silver;

import java.util.Scanner;

public class S2302_극장_좌석 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] VIP = new int[M];
        for (int i = 0; i< M; i++) {
            VIP[i] = sc.nextInt();
        }

        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        if (N > 1) {
            dp[2] = 2;
        }
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int result = 1;
        int prev = 0;

        for (int i = 0; i < M; i++) {
            int start = VIP[i] - 1;
            int len = start - prev;
            result = result * dp[len];
            prev = VIP[i];
        }

        if (prev < N) {
            result = result * dp[N-prev];
        }
        System.out.println(result);
    }
}
