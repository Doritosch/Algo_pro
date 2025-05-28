import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> declare = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        int[] answer = new int[id_list.length];
        
        for(int i=0; i<id_list.length; i++) {
            declare.put(id_list[i], new HashSet<>());
            result.put(id_list[i], 0);
        }
        
        for(int i=0; i<report.length; i++) {
            String[] s = report[i].split(" ");
            declare.get(s[1]).add(s[0]);
        }
        
        for(int i=0; i<id_list.length; i++) {
            if ( declare.get(id_list[i]).size() >= k ) {
                Set<String> values = declare.get(id_list[i]);
                for(String value : values) {
                    result.put(value, result.get(value)+1);
                }
            }
        }
        
        for(int i=0; i<id_list.length; i++) {
            answer[i] = result.get(id_list[i]);
        }
        return answer;
    }
}