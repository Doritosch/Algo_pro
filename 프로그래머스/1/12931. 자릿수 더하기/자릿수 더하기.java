import java.util.*;

public class Solution {
    public int solution(int n) {
        int sum = 0;
        while(n>0) {
            int div = n % 10;
            sum += div;
            n /= 10;
        }
        return sum;
    }
}