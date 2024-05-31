import java.util.*;

public class Solution {
    static int ans=1;
    public int solution(int n) {
        if(n==1) return ans;
        if(n%2!=0){
            ans+=1;
            return solution(n-1);
        }
        else{
            return solution(n/2);
        }
    }
}