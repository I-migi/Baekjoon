package Baekjoon.Silver;

import java.util.Scanner;

public class S2531_회전_초밥 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = sc.nextInt();
        }

        int[] count = new int[d+1];
        int uniqueCount = 0;

        for (int i = 0; i < k; i++) {
            if (count[sushi[i]] == 0) {
                uniqueCount++;
            }
            count[sushi[i]]++;
        }

        int maxUniqueCount = uniqueCount + (count[c] == 0 ? 1 : 0);

        for (int i = 1; i < N; i++) {
            int removeSushi = sushi[i-1];
            count[removeSushi]--;
            if (count[removeSushi] == 0) {
                uniqueCount--;
            }

            int addSushi = sushi[(i + k - 1) % N];
            if (count[addSushi] == 0) {
                uniqueCount++;
            }
            count[addSushi]++;

            maxUniqueCount = Math.max(maxUniqueCount, uniqueCount + (count[c] == 0 ? 1 : 0));
        }
        System.out.println(maxUniqueCount);
    }
}
