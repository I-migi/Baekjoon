package Baekjoon.Silver;
import java.util.Scanner;

public class S1991_트리_순회 {
	static int[][] tree;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		tree = new int[26][2];

		for (int i = 0; i < N; i++) {
			char parent = scanner.next().charAt(0);
			char left = scanner.next().charAt(0);
			char right = scanner.next().charAt(0);

			int parentIndex = parent - 'A';
			tree[parentIndex][0] = (left == '.' ? -1 : left - 'A');
			tree[parentIndex][1] = (right == '.' ? -1 : right - 'A');
		}

		preorder(0);
		System.out.println();
		inorder(0);
		System.out.println();
		postorder(0);
	}

	static void preorder(int node) {
		if (node == -1) return;
		System.out.print((char)(node + 'A'));
		preorder(tree[node][0]);
		preorder(tree[node][1]);
	}

	static void inorder(int node) {
		if (node == -1) return;
		inorder(tree[node][0]);
		System.out.print((char)(node + 'A'));
		inorder(tree[node][1]);
	}

	static void postorder(int node) {
		if (node == -1) return;
		postorder(tree[node][0]);
		postorder(tree[node][1]);
		System.out.print((char)(node + 'A'));

	}

	}

