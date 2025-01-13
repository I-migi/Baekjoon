package Baekjoon.Silver;

import java.util.Scanner;

public class S5525_IOIOI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String S = sc.next();
        int length = 0;
        int answer = 0;

        for (int i = 0; i < M-1; i++) {

            if (S.charAt(i) == 'I' && i+2 < M && S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
                length++;
                if (length >= N) {
                    answer++;
                }
                i++;
            } else {
                length = 0;
            }
        }

        System.out.println(answer);
    }
}
