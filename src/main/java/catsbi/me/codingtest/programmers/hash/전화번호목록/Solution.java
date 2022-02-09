package catsbi.me.codingtest.programmers.hash.전화번호목록;

import java.util.Arrays;

public class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length - 1; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1])) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        boolean result1 = new Solution().solution(new String[]{"119", "97674223", "1195524421"});
        boolean result2 = new Solution().solution(new String[]{"123", "456", "789"});
        boolean result3 = new Solution().solution(new String[]{"12", "123", "1235", "567", "88"});

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);

    }
}
