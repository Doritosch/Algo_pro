class Solution {
    public long solution(int price, int money, int count) {
        long change = (long)money;
        for(int i=1; i<=count; i++) {
            change -= price*i;
        }
        if (change>=0) {
            return 0;
        }
        return change * -1;
    }
}