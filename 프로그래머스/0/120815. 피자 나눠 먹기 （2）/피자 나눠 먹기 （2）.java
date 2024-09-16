class Solution {
    public int solution(int n) {
        int i=0;
        for(i=1; i<=n*6; i++) {
            if((i*6)%n==0) return i;
        }
        return i;
    }
}