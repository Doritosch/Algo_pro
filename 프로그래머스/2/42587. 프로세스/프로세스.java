import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++) {
            q.add(new int[]{priorities[i], i});
        }
        
        int count = 1;
        while(!q.isEmpty()) {
            int[] process = q.poll();
            
            boolean isHigher = false;
            
            for(int[] priority : q) {
                if (priority[0] > process[0]) {
                    isHigher = true;
                    break;
                }
            }
            
            if (isHigher) {
                q.add(process);
            } else {
                if (process[1] == location) {
                    return count;
                }
                count++;
            }
        }
        return 0;
    }
}