import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(String[] strlist) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<strlist.length; i++) {
            answer.add(strlist[i].length());
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}