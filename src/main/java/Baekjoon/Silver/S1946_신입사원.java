package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class S1946_신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            List<int[]> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int i1 = Integer.parseInt(st.nextToken());
                int i2 = Integer.parseInt(st.nextToken());
                list.add(new int[]{i1, i2});
            }

            list.sort(Comparator.comparingInt(a -> a[0]));

            int min = Integer.MAX_VALUE;
            int count = 0;

            for (int[] applicant : list) {
                if (applicant[1] < min) {
                    count++;
                    min = applicant[1];
                }
            }
            System.out.println(count);
        }
    }
}
