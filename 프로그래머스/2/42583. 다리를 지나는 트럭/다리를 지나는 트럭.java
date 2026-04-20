import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitTruck = new LinkedList<>();
        Queue<Integer> bridgeTruck = new LinkedList<>();
        
        for(int truckWeight : truck_weights) {
            waitTruck.add(truckWeight);
        }
        for(int i=0; i<bridge_length; i++) {
            bridgeTruck.add(0);
        }
        
        int sec = 0;
        int bridgeWeight = 0;
        while(!waitTruck.isEmpty()) {
            sec++;
            
            bridgeWeight -= bridgeTruck.poll();
            
            if (waitTruck.peek() + bridgeWeight <= weight) {
                int cur = waitTruck.poll();
                bridgeTruck.add(cur);
                bridgeWeight += cur;
            } else {
                bridgeTruck.add(0);
            }
        }
        return sec + bridge_length;
    }
}