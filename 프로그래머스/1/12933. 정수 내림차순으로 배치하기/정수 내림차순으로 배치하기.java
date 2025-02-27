import java.util.*;
class Solution {
    public long solution(long n) {
        String s = "" + n;
        long answer = 0;
        int[] arr = new int[s.length()];
        
        for(int i=0; i<s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }
        
        Arrays.sort(arr);
        
        for(int i=arr.length-1; i>=0; i--) {
            answer = answer*10 + (int)arr[i];
        }
        return answer;
    }
}