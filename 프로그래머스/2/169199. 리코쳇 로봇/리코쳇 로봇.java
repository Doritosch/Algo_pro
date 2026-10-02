import java.util.*;

class Solution {
    int[][] distance;
    char[][] maps;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(String[] board) {
        distance = new int[board.length][board[0].length()];
        maps = new char[board.length][board[0].length()];
        
        for(int i=0; i<distance.length; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);   
        }
        
        Node start = null;
        Node end = null;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length(); j++) {
                maps[i][j] = board[i].charAt(j);
                if (maps[i][j] == 'R') {
                    start = new Node(i, j);
                }
                if (maps[i][j] == 'G') {
                    end = new Node(i, j);
                }
            }
        }
        
        bfs(start);
        
        return distance[end.x][end.y] == Integer.MAX_VALUE ? -1 : distance[end.x][end.y];
    }
    public void bfs(Node n) {
        Queue<Node> q = new LinkedList<>();
        q.offer(n);
        distance[n.x][n.y] = 0;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = cur.x;
                int ny = cur.y;
                
                while(isRange(nx+dx[i], ny+dy[i]) 
                      && maps[nx+dx[i]][ny+dy[i]] != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                
                if (distance[nx][ny] != Integer.MAX_VALUE) continue;
                
                distance[nx][ny] = distance[cur.x][cur.y] + 1;
                q.offer(new Node(nx, ny));
            }
        }
    }
    public boolean isRange(int x, int y) {
        if ((x>=0&&y>=0) && (x<maps.length&&y<maps[0].length)) {
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