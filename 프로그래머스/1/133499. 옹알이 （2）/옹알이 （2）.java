import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] speak = {"aya", "ye", "woo", "ma"};
        
        for(int i=0; i<babbling.length; i++) {
            for(int j=0; j<speak.length; j++) {
                String word = babbling[i];
                if ( word.contains("ayaaya") || word.contains("yeye") ||
                   word.contains("woowoo") || word.contains("mama") ) {
                    continue;
                }
                babbling[i] = babbling[i].replace(speak[j], " ");
            }
            babbling[i] = babbling[i].replace(" ", "");
        }
        
        for(int i=0; i<babbling.length; i++) {
            if (babbling[i].length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}