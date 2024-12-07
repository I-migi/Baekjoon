package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] arr = new ArrayList[V+1];

		for (int j = 0; j < arr.length; j++) {
			arr[j] = new ArrayList<>();
		}

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			while (Integer.parseInt(st.nextToken()) != -1) {
				int nextNode = Integer.parseInt(st.nextToken());
				int length = Integer.parseInt(st.nextToken());

				arr[node].add(nextNode);


			}
		}
	}
}
