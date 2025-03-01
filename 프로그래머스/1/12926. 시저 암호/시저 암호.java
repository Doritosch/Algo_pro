import java.io.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        
        for(int i=0; i<s.length(); i++) {
            char spell = s.charAt(i);
            if(spell==' ') {
                sb.append(" ");
            } else {
                if(spell-'a'<0) {
                    sb.append( (char)('A'+(spell - 'A' + n) % 26));
                } else {
                    sb.append( (char)('a'+(spell - 'a' + n) % 26));
                }
            }
        }
        return sb.toString();
    }
}