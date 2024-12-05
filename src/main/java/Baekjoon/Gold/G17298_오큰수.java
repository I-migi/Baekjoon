package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class G17298_오큰수 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] answer = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			answer[i] = -1;
		}


		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				answer[stack.pop()] = arr[i];
			}
			stack.push(i);
		}

		for (int i = 0; i < N; i++) {
			bw.write(answer[i] + " ");
		}

		bw.flush();
		bw.close();
	}
}
