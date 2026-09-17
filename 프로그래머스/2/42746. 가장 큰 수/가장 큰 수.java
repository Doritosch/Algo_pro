import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<numbers.length; i++) {
            list.add(numbers[i]);
        }
        
        Collections.sort(list, (a,b) -> {
            String as = String.valueOf(a);
            String bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as+bs), Integer.parseInt(bs+as));
        });
        
        StringBuilder sb = new StringBuilder();
        for(Integer num : list) {
            sb.append(num);
        }
        
        String answer = sb.toString();
        if (answer.charAt(0) == '0') {
            return "0";
        }
        return answer;
    }
}