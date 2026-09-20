import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> wait = new LinkedList<>();
        Queue<Integer> way = new LinkedList<>();
        
        for(int i=0; i<truck_weights.length; i++) {
            wait.add(truck_weights[i]);
        }
        
        for(int i=0; i<bridge_length; i++) {
            way.add(0);
        }
        
        int sec = 0;
        int bridge_weight = 0;
        while(!wait.isEmpty()) {
            sec += 1;
            
            bridge_weight -= way.poll();
            
            if (wait.peek() + bridge_weight <= weight) {
                int cur = wait.poll();
                way.add(cur);
                bridge_weight += cur;
            } else {
                way.add(0);
            }
        }
        return sec + bridge_length;
    }
}