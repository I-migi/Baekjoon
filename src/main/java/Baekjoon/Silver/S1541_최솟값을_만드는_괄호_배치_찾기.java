package Baekjoon.Silver;

import java.util.Scanner;

public class S1541_최솟값을_만드는_괄호_배치_찾기 {
	static int answer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String example = sc.nextLine();
		String[] str = example.split("-");

		for (int i =0; i<str.length; i++) {
			int temp = mySum(str[i]);
			if (i == 0)
				answer = answer + temp;
			else
				answer = answer - temp;
		}
		System.out.println(answer);


	}

	private static int mySum(String a) {
		int sum =0;
		String temp[] = a.split("[+]");
		// a.split 에서 + 를 인식 못하는 경우가 가끔 발생 -> [ ] 로 감싸줘야 한다
		for (int i =0; i<temp.length; i++) {
			sum = sum + Integer.parseInt(temp[i]);
		}
		return sum;
	}
}
