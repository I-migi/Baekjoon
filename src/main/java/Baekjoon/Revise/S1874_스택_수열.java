package Baekjoon.Revise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class S1874_스택_수열 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();
		StringBuilder result = new StringBuilder();
		int currentNumber = 1;

		for (int i = 0; i < n; i++) {
			int target = arr[i];

			while (currentNumber <= target) {
				stack.push(currentNumber);
				result.append("+\n");
				currentNumber++;
			}

			if (stack.peek() == target) {
				stack.pop();
				result.append("-\n");
			} else {
				bw.write("NO\n");
				bw.flush();
				return;
			}

		}

		bw.write(result.toString());
		bw.flush();
		bw.close();
	}
}
