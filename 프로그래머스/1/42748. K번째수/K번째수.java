import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
            int length = commands[i][1]-commands[i][0]+1;
            int[] copyArr = new int[length];
            
            for(int j=0; j<length; j++) {
                copyArr[j] = array[commands[i][0]+j-1];
            }
            
            Arrays.sort(copyArr);
            
            answer[i] = copyArr[commands[i][2]-1];
        }
        return answer;
    }
}