class Solution {
    public int solution(int num) {
        int i = 0;
        long n = (long)num;
        // 입력된 수가 짝수라면 2로 나눈다.
        // 입력된 수가 홀수라면 3을 곱하고 1을 더한다.
        while(i < 500) {
            if (n == 1) {
                return i;
            }
            
            if (n%2 == 0) {
                n /= 2;
            } else {
                n = n*3 + 1;
            }
            i++;
        }
        return -1;
    }
}