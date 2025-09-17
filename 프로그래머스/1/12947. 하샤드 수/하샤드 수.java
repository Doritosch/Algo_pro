class Solution {
    public boolean solution(int x) {
        int n = x;
        int sum = 0;
        while(n>0) {
            int div = n%10;
            sum += div;
            n /= 10;
        }
        
        if (x%sum == 0) {
            return true;
        }
        return false;
    }
}