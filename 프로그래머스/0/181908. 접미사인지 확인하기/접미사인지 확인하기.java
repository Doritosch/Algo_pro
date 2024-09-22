class Solution {
    public int solution(String my_string, String is_suffix) {
        int target = my_string.length()-is_suffix.length();
        int answer = (my_string.indexOf(is_suffix,target)==target)&&(my_string.length()>=is_suffix.length())?1:0;
        
        return answer;
    }
}