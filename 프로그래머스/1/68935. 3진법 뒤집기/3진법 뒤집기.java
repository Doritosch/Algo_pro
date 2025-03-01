import java.util.*;
import java.io.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        while(n>0) {
            stack.push(n%3);
            n /= 3;
        }
        
        int i=1;
        while(!stack.isEmpty()) {
            int p = stack.pop();
            answer += p*i;
            i*=3;
        }
        return answer;
    }
}