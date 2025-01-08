package Baekjoon.Silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S5014_스타트링크 {
    static boolean[] visited;
    static int F, U, D, G, count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        int S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        visited = new boolean[F + 1];
        int result = BFS(S);
        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }
    }


    private static int BFS(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int currentFloor = current[0];
            int currentCount = current[1];

            if (currentFloor == G) {
                return currentCount;
            }

            int nextFloorUp = currentFloor + U;

            if (nextFloorUp <= F && !visited[nextFloorUp]) {
                queue.add(new int[]{nextFloorUp, currentCount + 1});
                visited[nextFloorUp] = true;
            }
            int nextFloorDown = currentFloor - D;
            if (nextFloorDown > 0 && !visited[nextFloorDown]) {
                queue.add(new int[]{nextFloorDown, currentCount + 1});
                visited[nextFloorDown] = true;
            }
        }
        return -1;
    }
}
