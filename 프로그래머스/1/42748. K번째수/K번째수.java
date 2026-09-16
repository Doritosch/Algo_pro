import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
            int s = commands[i][0];
            int e = commands[i][1];
            int[] arr = new int[e-s+1];
            for(int j=0; j<=e-s; j++) {
                arr[j] = array[j+s-1];
            }
            
            Arrays.sort(arr);
            
            answer[i] = arr[commands[i][2]-1];
        }
        return answer;
    }
}