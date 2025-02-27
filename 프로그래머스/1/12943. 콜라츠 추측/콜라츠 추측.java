class Solution {
    public int solution(int num) {
        int answer = 0;
        long value = num;
        while(answer<=500) {
            if(value==1) {
                return answer;
            }
            if(value%2==0) {
                value/=2;
            } else {
                value = (value*3) + 1;
            }
            answer++;
        }
        return -1;
    }
}