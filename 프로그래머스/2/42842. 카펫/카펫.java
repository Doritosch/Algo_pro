class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        
        for(int x=brown/2; x>0; x--){
            int y = brown/2-x;
            if((x-2)*y==yellow){
                answer[0] = x;
                answer[1] = y+2;
                return answer;
            }
        }
        
        return answer;
    }
}