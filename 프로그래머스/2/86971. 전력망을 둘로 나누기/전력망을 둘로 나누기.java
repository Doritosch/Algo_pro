class Solution {
    int[][] graph;
    boolean[] visited;
    int n;
    public int solution(int n, int[][] wires) {
        int answer = n+1;
        
        graph = new int[n+1][n+1];
        this.n = n;
        for(int i=0; i<n-1; i++) {
            graph[wires[i][0]][wires[i][1]] = 1;
            graph[wires[i][1]][wires[i][0]] = 1;
        }
        
        for(int i=0; i<n-1; i++) {
            graph[wires[i][0]][wires[i][1]] = 0;
            graph[wires[i][1]][wires[i][0]] = 0;
            answer = Math.min(answer, process());
            graph[wires[i][0]][wires[i][1]] = 1;
            graph[wires[i][1]][wires[i][0]] = 1;
        }
        return answer;
    }
    public int process() {
        visited = new boolean[n+1];
        int f = dfs(1);
        return Math.abs(2*f-n);
    }
    public int dfs(int idx) {
        visited[idx] = true;
        int count = 1;
        for(int i=1; i<=n; i++) {
            if (!visited[i] && graph[idx][i] == 1) {
                visited[i] = true;
                count += dfs(i);
            }
        }
        return count;
    }
}