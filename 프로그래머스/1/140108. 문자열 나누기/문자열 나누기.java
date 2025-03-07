class Solution {
    public int solution(String s) {
        int answer = 0;
        int count = 0;
        char ch = 'a';
        for(int i=0; i<s.length(); i++) {
            if ( count == 0 ) {
                ch = s.charAt(i);
                count += 1;
                answer += 1;
            } else {
                if (ch == s.charAt(i) ) {
                    count += 1;
                } else {
                    count -= 1;
                }
            }
        }
        return answer;
    }
}