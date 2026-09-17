import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(int j=0; j<s.length(); j++) {
                char c = s.charAt((i+j)%s.length());
                
                if (c == '[' || c == '{' || c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if (c == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else if (c == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (c == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            
            if (flag && stack.isEmpty()) {
                answer += 1;
            }
        }
        return answer;
    }
}