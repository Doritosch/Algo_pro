import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        String answer = "";
        
        for(String member : participant) {
            map.put(member, map.getOrDefault(member, 0)+1);
        }
        
        for(String member : completion) {
            map.put(member, map.get(member)-1);
        }
        
        for(String member : map.keySet()) {
            if (map.get(member) != 0) {
                return member;
            }
        }
        return answer;
    }
}