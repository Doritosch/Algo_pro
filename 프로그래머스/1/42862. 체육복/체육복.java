import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n+1];
        
        for(int s : lost) {
            student[s]--;
        }
        for(int s : reserve) {
            student[s]++;
        }
        
        for(int i=1; i<=n; i++) {
            if ( student[i] == 1 ) {
                if ( i-1>0 && student[i-1]==-1 ) {
                    student[i]--;
                    student[i-1]++;
                } else if ( i+1<=n && student[i+1]==-1 ) {
                    student[i]--;
                    student[i+1]++;
                }
            }
        }
        
        int answer = 0;
        for(int i=1; i<=n; i++) {
            if (student[i] >= 0) {
                answer++;
            }
        }
        
        return answer;
    }
}