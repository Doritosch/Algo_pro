class Solution {
    public long solution(long n) {
        long answer = 0;
        double value = Math.sqrt(n);
        answer = (long)value;
        
        if(answer-value!=0) {
            return -1;
        }
        
        answer = (answer+1)*(answer+1);
        return answer;
    }
}