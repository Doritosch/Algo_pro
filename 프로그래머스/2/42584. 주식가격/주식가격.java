import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int peek = stack.pop();
                answer[peek] = i - peek;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int p = stack.pop();
            answer[p] = prices.length - p - 1;
        }
        
        return answer;
    }
}