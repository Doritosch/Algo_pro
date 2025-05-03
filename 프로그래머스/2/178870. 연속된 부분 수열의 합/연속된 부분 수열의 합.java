class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int l=0, r=0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        
        while(r<sequence.length) {
            sum += sequence[r];
            
            while ( sum>k ) {
                sum -= sequence[l];
                l++;
            }
            
            if ( sum == k ) {
                if ( minLen > r-l ) {
                    minLen = r-l;
                    answer[0] = l;
                    answer[1] = r;
                }
            }
            
            r++;
        }
        return answer;
    }
}