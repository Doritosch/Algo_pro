import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> result = new HashMap<>();
        
        for(String p : participant) result.put(p, result.getOrDefault(p, 0) + 1);
        for(String c : completion) result.put(c, result.get(c) - 1);
        for(String r : result.keySet()) {
            if (result.get(r) != 0) {
                answer = r;
            }
        }
        return answer;
    }
}