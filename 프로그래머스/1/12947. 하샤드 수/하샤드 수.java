class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int sum = 0;
        String s = "" + x;
        for(int i=0; i<s.length(); i++) {
            sum += s.charAt(i)-'0';
        }
        
        if(x%sum==0) {
            answer = true;
        }
        return answer;
    }
}