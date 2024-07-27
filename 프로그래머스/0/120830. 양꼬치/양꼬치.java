class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        if((n>0 && n<1000)&&(k>=n/10&&k<1000)) {
            k = k - n/10;
            answer = n*12000 + k*2000;
        }
        return answer;
    }
}