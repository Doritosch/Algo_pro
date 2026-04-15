import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                answer.add(arr[i]);
            }
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
                answer.add(arr[i]);
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}