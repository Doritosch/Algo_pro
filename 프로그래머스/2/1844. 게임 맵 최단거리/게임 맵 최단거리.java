import java.util.*;

class Solution {
    int[][] maps;
    int[][] visited;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(int[][] maps) {
        this.maps = maps;
        visited = new int[maps.length][maps[0].length];
        
        bfs(0, 0);
        
        int answer = visited[maps.length-1][maps[0].length-1];
        if (answer == 0) {
            return -1;
        }
        return answer;
    }
    public void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = 1;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (isRange(nx, ny) && visited[nx][ny] == 0) {
                    if (maps[nx][ny] != 0) {
                        q.offer(new Node(nx, ny));
                        visited[nx][ny] = visited[cur.x][cur.y] + 1;
                    }
                }
            }
        }
    }
    public boolean isRange(int x, int y) {
        if ((x<0 || y<0) || (x>=maps.length || y>=maps[0].length)) {
            return false;
        }
        return true;
    }
    public class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}