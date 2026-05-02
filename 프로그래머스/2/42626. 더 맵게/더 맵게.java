import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville) {
            pq.offer(s);
        }
        
        int count = 0;
        while(pq.peek() < K) {
            if (pq.size() <= 1) {
               return -1; 
            }
            
            int first = pq.poll();
            int cal = first + (pq.poll() * 2);
            pq.offer(cal);
            count++;
        }
        return count;
    }
}