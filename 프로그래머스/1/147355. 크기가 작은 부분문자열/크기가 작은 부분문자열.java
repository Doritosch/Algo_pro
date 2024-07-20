class Solution {
    public int solution(String t, String p) {
        int tLength = t.length();
        int pLength = p.length();
        long iP = Long.parseLong(p);
        int count = 0;

        for(int i=0; i<tLength-pLength+1; i++) {
            long c = Long.parseLong(t.substring(i,i+pLength));

            if(iP >= c) {
                count++;
            }
        }
        return count;
    }
}