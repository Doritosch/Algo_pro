import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        
        for(int value:arr) {
            if(value%divisor==0) {
                list.add(value);
            }
        }
        
        if(list.size()==0) {
            return new int[] {-1};
        }
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}