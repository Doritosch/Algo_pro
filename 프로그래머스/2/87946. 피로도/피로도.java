class Solution {
    static boolean[] visited;
    static int[][] dungeons;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        this.dungeons = dungeons;
        this.answer = 0;
        
        dfs(0, k, 0);
        return answer;
    }
    public void dfs(int depth, int fatigue, int count) {
        answer = Math.max(answer, count);
        
        for(int i=0; i<dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                visited[i] = true;
                dfs(depth+1, fatigue-dungeons[i][1], count+1);
                visited[i] = false;
            }
        }
    }
}