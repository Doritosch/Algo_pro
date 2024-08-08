import java.util.*;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        Arrays.sort(array);
        
        answer = (array.length%2==0) ? array[array.length/2] : array[array.length/2];
        return answer;
    }
}