import java.util.*;
class Solution {
    public long solution(long n) {
        int[] digits = new int[10];
        long answer = 0;
        while(n>0) {
            int digit = (int)(n % 10);
            digits[digit]++;
            n /= 10;
        }
        
        for(int i=0; i<10; i++) {
            if (digits[9-i] != 0) {
                for(int j=0; j<digits[9-i]; j++) {
                    answer *= 10;
                    answer += 9-i;
                }
            }
        }
        return answer;
    }
}