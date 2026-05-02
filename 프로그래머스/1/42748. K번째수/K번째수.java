import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<commands.length; i++) {
            int len = commands[i][1] - commands[i][0] + 1;
            int[] arr = new int[len];
            
            for(int j=0; j<len; j++) {
                arr[j] = array[commands[i][0]-1+j];
            }
            for(int j=0; j<len-1; j++) {
                for(int k=j+1; k<len; k++) {
                    if (arr[j] > arr[k]) {
                        int temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;
                    }
                }
            }
            list.add(arr[commands[i][2]-1]);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}