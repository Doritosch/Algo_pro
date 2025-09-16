import java.util.*;
class Solution {
    public int[] solution(long n) {
        Queue<Long> q = new LinkedList<>();
        
        while(n>0) {
            long v = n % 10;
            q.add(v);
            n /= 10;
        }
        
        int[] answer = new int[q.size()];
        int idx = 0;
        while(!q.isEmpty()) {
            answer[idx++] = q.poll().intValue();
        }
        return answer;
    }
}