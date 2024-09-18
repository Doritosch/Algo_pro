import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int length = emergency.length;
        
        int[] answer = new int[length];
        List<Integer> copyEmergency = new ArrayList<>();
        for(int num : emergency) {
            copyEmergency.add(num);
        }
        
        int[] sortedEmergency = Arrays.copyOf(emergency, length);
        Arrays.sort(sortedEmergency);
        
        int count = 1;
        
        for(int i=length-1; i>=0; i--) {
            int target = sortedEmergency[i];
            answer[copyEmergency.indexOf(target)] = count++;
        }
        return answer;
    }
}