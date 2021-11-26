package catsbi.me.algorithm.baekjoon;

import java.util.Scanner;

/**
 * @link https://www.acmicpc.net/problem/2439
 */
public class 별찍기_2439 {
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();

        //logic
        String answer = solution(first);

        //output
        System.out.println(answer);
    }


    public static String solution(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            for (int j = count; j > 0; j--) {
                if (j <= i) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
