import java.io.*;
class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<food.length; i++) {
            for(int j=0; j<food[i]/2; j++) {
                sb.append(i);
            }
        }
        
        String str = sb.toString();
        String reversedStr = sb.reverse().toString();
        String answer = str + "0" + reversedStr;
        
        return answer;
    }
}