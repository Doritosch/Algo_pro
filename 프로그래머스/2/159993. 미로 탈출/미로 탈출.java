import java.util.*;
class Solution {
    String[] maps;
    int[][] distance;
    boolean[][] visited;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(String[] maps) {
        this.maps = maps;
        
        int start = 0, end = 0;
        int answer = 0;
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    start = bfs(i, j, 'L');
                }
                if (maps[i].charAt(j) == 'L') {
                    end = bfs(i, j, 'E');
                }
            }
        }
        
        if (start == -1 || end == -1) {
            answer = -1;
        } else {
            answer = start + end;
        }
        
        return answer;
    }
    public int bfs(int x, int y, char target) {
        this.distance = new int[maps.length][maps[0].length()];
        this.visited = new boolean[maps.length][maps[0].length()];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            if (maps[cur.x].charAt(cur.y) == target) {
                return distance[cur.x][cur.y];
            }
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (isRange(nx, ny) && !visited[nx][ny]) {
                    if (maps[nx].charAt(ny) != 'X') {
                        q.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[cur.x][cur.y] + 1;
                    }
                }
            }
        }
        return -1;
    }
    public boolean isRange(int x, int y) {
        if ((x>=0&&y>=0) && (x<maps.length&&y<maps[0].length())) {
            return true;
        }
        return false;
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