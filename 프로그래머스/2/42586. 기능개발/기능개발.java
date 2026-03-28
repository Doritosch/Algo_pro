import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++) {
            int day = (int)Math.ceil((100.0-progresses[i])/speeds[i]);
            queue.offer(day);
        }
        
        while(!queue.isEmpty()) {
            int deployDay = queue.poll();
            int count = 1;
            
            while(!queue.isEmpty() && deployDay >= queue.peek()) {
                queue.poll();
                count++;
            }
            answer.add(count);
        }
        
        return answer.stream()
            .mapToInt(i->i)
            .toArray();
    }
}