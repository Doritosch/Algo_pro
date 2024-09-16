class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int x = dots[0][0];
        int y = dots[0][1];
        
        for(int i=1; i<dots.length; i++) {
            if(x != dots[i][0]) {
                x -= dots[i][0];
                break;
            }
        }
        
        for(int i=1; i<dots.length; i++) {
            if(y != dots[i][1]) {
                y -= dots[i][1];
                break;
            }
        }
        
        answer = x*y;
        
        if(answer<0) answer*=-1;
        
        return answer;
    }
}