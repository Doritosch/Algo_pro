import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<operations.length; i++) {
            String[] cmd = operations[i].split(" ");
            char c = cmd[0].charAt(0);
            int num = Integer.parseInt(cmd[1]);
            
            if (c == 'I') {
                minQ.offer(num);
                maxQ.offer(num);
            } else if (c == 'D') {
                if (minQ.isEmpty()) {
                    continue;
                }
                if (num == 1) {
                    int removeNum = maxQ.poll();
                    minQ.remove(removeNum);
                } else {
                    int removeNum = minQ.poll();
                    maxQ.remove(removeNum);
                }
            }
        }
        
        if (minQ.isEmpty()) {
            return new int[]{0,0};
        }
        return new int[]{maxQ.poll(), minQ.poll()};
    }
}