import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] checked = new int[26];
        Arrays.fill(checked, -1);
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(checked[ch - 'a'] == -1) {
                answer[i] = -1;
                checked[ch - 'a'] = i;
            } else {
                answer[i] = i - checked[ch - 'a'];
                checked[ch - 'a'] = i;
            }
        }
        return answer;
    }
}