package catsbi.me.codingtest.programmers.hash.완주하지못한선수;

import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }


        }
        return participant[participant.length-1];
    }
}
