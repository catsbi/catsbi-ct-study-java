package catsbi.me.algorithm.baekjoon;

import java.util.Scanner;

/**
 * @link https://www.acmicpc.net/problem/10871
 */
public class X보다_작은_수_10871 {
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();

        for (int i = 0; i < first; i++) {
            final int num = scanner.nextInt();
            if (num < second) {
                System.out.printf("%d ", num);
            }
        }
    }
}
