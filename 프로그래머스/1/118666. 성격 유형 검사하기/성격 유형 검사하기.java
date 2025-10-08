import java.util.*;
class Solution {
    static Map<Character, Integer> map;
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        init();
        for(int i=0; i<survey.length; i++) {
            int score = choices[i] - 4;
            if (score < 0) {
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0))+Math.abs(score));
            } else {
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1))+score);
            }
        }
        
        answer = getPersonal(answer, 'R', 'T');
        answer = getPersonal(answer, 'C', 'F');
        answer = getPersonal(answer, 'J', 'M');
        answer = getPersonal(answer, 'A', 'N');
        return answer;
    }
    public void init() {
        map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('F', 0);
        map.put('C', 0);
        map.put('M', 0);
        map.put('J', 0);
        map.put('A', 0);
        map.put('N', 0);
    }
    public String getPersonal(String s, char c1, char c2) {
        if (map.get(c1) < map.get(c2)) {
            return s + c2;
        } else {
            return s + c1;
        }
    }
}