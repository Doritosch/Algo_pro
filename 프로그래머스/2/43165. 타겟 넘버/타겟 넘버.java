class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }
    public void dfs(int[] numbers, int target, int idx, int num) {
        if (idx >= numbers.length) {
            return;
        }
        if (numbers.length-1 == idx && 
            (num+numbers[idx] == target || num-numbers[idx] == target)) {
            answer += 1;
            return;
        }
        
        dfs(numbers, target, idx+1, num+numbers[idx]);
        dfs(numbers, target, idx+1, num-numbers[idx]);
    }
}