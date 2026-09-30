import java.util.*;

class Solution {
    int[][] maps;
    boolean[][] visited;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int[] solution(String[] maps) {
        this.maps = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<this.maps.length; i++) {
            for(int j=0; j<this.maps[0].length; j++) {
                char ch = maps[i].charAt(j);
                if (ch == 'X') {
                    this.maps[i][j] = -1;
                } else {
                    this.maps[i][j] = ch - '0';
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<this.maps.length; i++) {
            for(int j=0; j<this.maps[0].length; j++) {
                if (this.maps[i][j] != -1 && !visited[i][j]) {
                    list.add(bfs(i, j));
                }
            }
        }
        
        Collections.sort(list);
        return list.isEmpty() 
            ? new int[]{-1} 
            : list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
    }
    public int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;
        int count = 0;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            count += maps[cur.x][cur.y];
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (isRange(nx, ny) && !visited[nx][ny]) {
                    if (maps[nx][ny] != -1) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny));   
                    }
                }
            }
        }
        return count;
    }
    public boolean isRange(int x, int y) {
        if ((x>=0 && y>=0) && (x<maps.length && y<maps[0].length)) {
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