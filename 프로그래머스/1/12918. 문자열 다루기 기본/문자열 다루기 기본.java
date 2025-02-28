class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if(s.length()!=4 && s.length()!=6) {
            return false;
        }
        
        for(int i=0; i<s.length(); i++) {
            int result = s.charAt(i)-'0';
            System.out.println(result);
            if(result<0 || result>10) {
                return false;
            }
        }
        return answer;
    }
}