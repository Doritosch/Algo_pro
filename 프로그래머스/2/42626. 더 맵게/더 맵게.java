import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) {
            q.offer(scoville[i]);
        }
        
        int count = 0;
        while(q.peek() < K) {
            int f = q.poll();
            if (q.isEmpty()) {
                return -1;
            }
            
            q.offer(f+(q.poll()*2));
            count += 1;
        }
        return count;
    }
}