package Baekjoon.Silver;

import java.io.IOException;
import java.util.*;

public class S2529_부등호 {
    static int k;
    static String[] operators;
    static boolean[] visited = new boolean[10];
    static ArrayList<String> results = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        operators = new String[k];
        for (int i = 0; i < k; i++) {
            operators[i] = sc.next();
        }

        backtrack(0,"");

        Collections.sort(results);
        System.out.println(results.get(results.size()-1));
        System.out.println(results.get(0));
    }

    private static void backtrack(int index, String result) {
        if (index == k + 1) {
            results.add(result);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                if (index ==0 || check(Integer.parseInt(String.valueOf(result.charAt(index-1))) , i, operators[index-1])) {
                    visited[i] = true;
                    backtrack(index+1, result + i);
                    visited[i] = false;
                }
            }
        }
    }

    private static boolean check(int a, int b, String operator) {
        if (operator.equals("<")) return a < b;
        if (operator.equals(">")) return a > b;
        return false;
    }
}