package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G1377_버블_소트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());



		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = Integer.parseInt(br.readLine());
			arr[i][1] = i;
		}

		Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));

		int max = 0;

		for (int i = 0; i < N; i++) {
			max = Math.max(max, arr[i][1] - i);
		}

		System.out.println(max + 1);


	}
}
