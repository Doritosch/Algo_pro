class Solution {
    public String solution(int age) {
        String alp = "abcdefghij";
        
        StringBuilder sb = new StringBuilder();
        
        while(age>0) {
            sb.insert(0, alp.charAt(age%10));
            age/=10;
        }
        return sb.toString();
    }
}