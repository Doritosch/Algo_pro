class Solution {
    public int solution(String s) {
        String parse = s.substring(1, s.length());
        if (s.charAt(0) == '-') {
            return -1 * Integer.parseInt(parse);
        }
        return Integer.parseInt(s);
    }
}