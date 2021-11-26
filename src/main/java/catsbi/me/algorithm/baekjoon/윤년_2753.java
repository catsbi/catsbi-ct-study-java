package catsbi.me.algorithm.baekjoon;

import java.util.Scanner;

/**
 * @link https://www.acmicpc.net/problem/2753
 */
public class 윤년_2753 {
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        //logic
        int answer = solution(year);

        //output
        System.out.println(answer);
    }


    public static int solution(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return 1;
        }
        return 0;
    }
}
