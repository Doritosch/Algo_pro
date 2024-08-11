import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[(int) Math.ceil((double)num_list.length/n)];
        
        for(int i=0, j=0; i<num_list.length; i+=n,j++) {
            answer[j] = num_list[i];
        }
        
        return answer;
    }
}