import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    String numbers;
    public int solution(String numbers) {
        this.numbers = numbers;
        visited = new boolean[numbers.length()];
        
        dfs("");
        
        int count = 0;
        for(Integer n : set) {
            if (isPrime(n)) {
                count += 1;
            }
        }
        return count;
    }
    public void dfs(String cur) {
        if (!cur.isEmpty()) {
            set.add(Integer.parseInt(cur));
        }
        
        for(int i=0; i<numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(cur + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if (num<2) return false;
        for(int i=2; (long)i*i<=num; i++) {
            if (num%i == 0) {
                return false;
            }
        }
        return true;
    }
}