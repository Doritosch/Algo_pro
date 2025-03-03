class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
       for (int i=1; i<=number; i++) {
           int ms = getMeasureNum(i);
           
           if (ms <= limit) {
               answer += ms;
           } else {
               answer += power;
           }
       }
        return answer;
    }
    int getMeasureNum(int n) {
        int measureNum = 0;
        for (int i=1; i*i<=n; i++) {
            if (i*i == n) {
                measureNum += 1;
            } else if (n%i == 0) {
                measureNum += 2;
            }
        }
        return measureNum;
    }
}