class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            for(int j=1; j<=index; j++) {
                ch = (char)('a' + (ch - 'a' + 1) % 26);
                if ( skip.contains(String.valueOf(ch)) ) {
                    j -= 1;
                }
            }
            
            answer += ch;
        }
        return answer;
    }
}