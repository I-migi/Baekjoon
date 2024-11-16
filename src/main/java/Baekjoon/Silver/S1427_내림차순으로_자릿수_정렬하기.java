package Baekjoon.Silver;

import java.util.Scanner;

public class S1427_내림차순으로_자릿수_정렬하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String stringN = sc.next();

		int[]A = new int[stringN.length()];

		for (int i = 0; i<stringN.length(); i++) {
			A[i] = Integer.parseInt(stringN.substring(i, i+1));
		}

		for (int i= 0; i<A.length; i++) {
			int Max = i;
			for (int j = i+1; j<A.length; j++) {
				if (A[j] >  A[Max])
					Max = j;
			}
			if (A[i] < A[Max]){
				int temp = A[i];
				A[i] = A[Max];
				A[Max] = temp;
			}
		}

		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]);
		}
	}
}
