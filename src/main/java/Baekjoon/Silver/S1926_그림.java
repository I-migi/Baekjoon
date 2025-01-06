package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1926_그림 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0}; // 상하좌우 이동
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;
    static int maxSize = 0;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    count++;
                    maxSize = Math.max(maxSize, DFS(i,j));
                }
            }
        }
        System.out.println(count);
        System.out.println(maxSize);
    }

    private static int DFS(int i, int j) {
        visited[i][j] = true;
        int size = 1;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] & arr[nx][ny] == 1) {
                size = size + DFS(nx, ny);
            }
        }
        return size;
    }


    }

