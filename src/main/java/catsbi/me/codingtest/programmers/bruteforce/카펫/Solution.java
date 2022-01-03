package catsbi.me.codingtest.programmers.bruteforce.카펫;

import java.util.Arrays;

class Solution {
    public int[] solution(int brown, int yellow) {
        for (int height = 1; height <= yellow; height++) {
            if (isDivisor(yellow, height) && equalsBrownTile(brown, yellow, height)) {
                return new int[]{yellow / height + 2, height + 2};
            }
        }
        return null;
    }

    private boolean equalsBrownTile(int brown, int yellow, int height) {
        return ((((yellow / height) + 2) * 2) + (height * 2)) == brown;
    }

    private boolean isDivisor(int yellow, int height) {
        return yellow % height == 0;
    }


    public static void main(String[] args) {
        final Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(10, 2)));
        System.out.println(Arrays.toString(s.solution(8, 1)));
        System.out.println(Arrays.toString(s.solution(24, 24)));
    }
}
