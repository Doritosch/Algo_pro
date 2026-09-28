import java.util.*;

class Solution {
    String[] words;
    int[] idx;
    public int solution(String begin, String target, String[] words) {
        this.words = words;
        idx = new int[words.length];
        
        bfs(begin);
        
        for(int i=0; i<words.length; i++) {
            if (words[i].equals(target)) {
                return idx[i];
            }
        }
        return 0;
    }
    public void bfs(String str) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<words.length; i++) {
            if (isValid(str, words[i])) {
                q.offer(i);
                idx[i] = 1;
            }
        }
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i=0; i<words.length; i++) {
                if (idx[i] == 0 && isValid(words[cur], words[i])) {
                    q.offer(i);
                    idx[i] = idx[cur] + 1;
                }
            }      
        }
    }
    public boolean isValid(String str, String c) {
        int count = 0;
        for(int i=0; i<str.length(); i++) {
            if (str.charAt(i) != c.charAt(i)) {
                count += 1;
            }
        }
        
        if (count == 1) {
            return true;
        }
        return false;
    }
}
