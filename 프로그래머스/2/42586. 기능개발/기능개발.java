import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++) {
            q.add((int)Math.ceil((100-progresses[i])/(double)speeds[i]));
        }
        
        while(!q.isEmpty()) {
            int count = 1;
            int data = q.poll();
            
            while(!q.isEmpty() && data >= q.peek()) {
                count++;
                q.poll();
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}