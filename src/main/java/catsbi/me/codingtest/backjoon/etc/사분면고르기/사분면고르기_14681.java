package catsbi.me.codingtest.backjoon.etc.사분면고르기;

import java.util.Scanner;

/**
 * @link https://www.acmicpc.net/problem/14681
 */
public class 사분면고르기_14681 {
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();

        //logic

        int answer = solution(first, second);

        //output
        System.out.println(answer);
    }


    public static int solution(int x, int y) {
        if (x > 0) {
            if (y > 0) {
                return 1;
            }
            return 4;
        }

        if (y > 0) {
            return 2;
        }
        return 3;
    }
}
