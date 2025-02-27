import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int value: arr) {
            list.add(value);
            if(min>value) {
                min = value;
                index = list.indexOf(min);
            };
        }
        
        list.remove(index);
        
        if(list.size()==0) {
            return new int[] {-1};
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}