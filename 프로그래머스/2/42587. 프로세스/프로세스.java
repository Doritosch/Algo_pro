import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++) {
            q.add(i);
        }
        
        int count = 0;
        while(!q.isEmpty()) {
            int p = q.poll();
            boolean isHigher = false;
            
            for(int idx : q) {
                if (priorities[idx] > priorities[p]) {
                    isHigher = true;
                    break;
                } 
            }
            
            if (isHigher) {
                q.add(p);
            } else {
                count += 1;
                if (location == p) return count;
            }
        }
        return count;
    }
}