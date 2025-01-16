package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S15903_카드_합체_놀이 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            Long first = queue.poll();
            Long second = queue.poll();
            Long third = first + second;
            queue.add(third);
            queue.add(third);
        }
        long sum = 0;

        while (!queue.isEmpty()) {
            sum += queue.poll();
        }
        System.out.println(sum);

    }
}
