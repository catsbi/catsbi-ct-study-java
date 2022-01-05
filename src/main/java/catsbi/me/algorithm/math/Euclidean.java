package catsbi.me.algorithm.math;

/**
 * 유클리드 알고리즘(Euclidean algorithm)을 사용한 최대공약수, 최소공배수 구하기
 */
public class Euclidean {
    public static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    public static int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }
}
