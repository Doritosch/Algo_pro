class Solution {
    public int mul(int[] num_list) {
        int mul = 1;
        for(int i=0; i<num_list.length; i++) {
            mul *= num_list[i];
        }
        return mul;
    }
    public int sum(int[] num_list) {
        int sum = 0;
        for(int i=0; i<num_list.length; i++) {
            sum += num_list[i];
        }
        return sum;
    }
    public int solution(int[] num_list) {
        int answer = num_list.length>10?sum(num_list):mul(num_list);
        
        
        return answer;
    }
}