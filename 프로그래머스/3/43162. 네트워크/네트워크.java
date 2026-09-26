class Solution {
    int[][] computers;
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        this.computers = computers;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer += 1;
            }
        }
        return answer;
    }
    public void dfs(int idx) {
        for(int i=0; i<computers.length; i++) {
            if (!visited[i] && computers[i][idx] == 1) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}