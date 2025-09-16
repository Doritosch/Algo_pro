class Solution {
    public long solution(long n) {
        double sqrtValue = Math.sqrt(n);
        long longValue = (long)sqrtValue;
        
        if (sqrtValue != longValue) {
            return -1;
        }
        
        return (longValue+1) * (longValue+1);
    }
}