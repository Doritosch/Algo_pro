class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for(int i=3; i*i<=total; i++) {
            if (total%i != 0) continue;
            int j = total / i;
            if ((i-2)*(j-2) == yellow) {
                return new int[]{j, i};
            }   
        }
        return new int[]{0,0};
    }
}