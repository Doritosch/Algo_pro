import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        for(int i=score.length; i>=m; i-=m) {
            int min = Integer.MAX_VALUE;
            for(int j=i-1; j>=i-m; j--) {
                if (j<0) {
                    break;
                }
                min = Math.min(min, score[j]);
            }
            answer += (min*m);
        }
        return answer;
    }
}