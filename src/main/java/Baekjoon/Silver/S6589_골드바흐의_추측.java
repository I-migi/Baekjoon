package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S6589_골드바흐의_추측 {
    static final int MAX = 1000000;
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 에라토스테네스의 체로 소수 계산
        eratosthenes(MAX);

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            boolean found = false;

            // 투 포인터 방식으로 소수 확인
            for (int a = 2; a <= N / 2; a++) {
                if (isPrime[a] && isPrime[N - a]) {
                    sb.append(N).append(" = ").append(a).append(" + ").append(N - a).append("\n");
                    found = true;
                    break;
                }
            }

            if (!found) {
                sb.append("Goldbach's conjecture is wrong.\n");
            }
        }

        System.out.print(sb);
    }

    private static void eratosthenes(int N) {
        isPrime = new boolean[N + 1];

        // 초기화
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}