class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if(a>b) {
            for(int i=0; i<=a-b; i++) {
                answer += (long)(b+i);
            }
        } else if(a==b) {
            answer = a;
        } else {
            for(int i=0; i<=b-a; i++) {
                answer += (long)(a+i);
            }
        }
        
        return answer;
    }
}