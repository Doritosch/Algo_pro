class Solution {
    public String mix(String str1, String str2) {
        int i=0;
        String mixed = "";
        for(i=0; i<str1.length(); i++) {
            mixed += str1.charAt(i);
            mixed += str2.charAt(i);
        }
        mixed += str2.substring(i,i+(str2.length()-str1.length()));
        return mixed;
    }
    public String solution(String str1, String str2) {
        String answer = str1.length()<=str2.length()?mix(str1,str2):mix(str2,str1);
        
        
        return answer;
    }
}