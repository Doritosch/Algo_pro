import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<commands.length; i++) {
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int target = commands[i][2];
            
            int[] arr = Arrays.copyOfRange(array, start, end);
            Arrays.sort(arr);
            
            list.add(arr[target-1]);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}