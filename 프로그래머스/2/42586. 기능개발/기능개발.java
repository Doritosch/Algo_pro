import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> counts = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++) {
            q.add((100-progresses[i]+speeds[i]-1)/speeds[i]);
        }
        
        while(!q.isEmpty()) {
            int deadline = q.poll();
            int count = 1;
            while(!q.isEmpty() && deadline >= q.peek()) {
                q.poll();
                count += 1;
            }
            counts.add(count);    
        }
        
        int[] answer = new int[counts.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = counts.get(i);
        }
        return answer;
    }
}