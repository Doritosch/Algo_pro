class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, 0, 0, target);
        return answer;
    }
    public void dfs(int[] numbers, int idx, int num, int target) {
        if (idx == numbers.length) {
            if (num == target) {
                answer++;
            }
            return;
        }
    
        dfs(numbers, idx+1, num+numbers[idx], target);
        dfs(numbers, idx+1, num-numbers[idx], target);
    }
}