class Solution {
    public long solution(int a, int b) {
        long A = (long)a;
        long B = (long)b;
        if (a<b) {
            return (long)((B*(B+1))/2 - ((A-1)*(A))/2);
        }
        return (long)((A*(A+1))/2 - ((B-1)*(B))/2);
    }
}