import java.util.*;
class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        map = new int[102][102];
        visited = new boolean[102][102];
        for(int i=0; i<rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            for(int j=x1; j<=x2; j++) {
                for(int k=y1; k<=y2; k++) {
                    map[j][k] = 1;
                }
            }
        }
        for(int i=0; i<rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            for(int j=x1+1; j<x2; j++) {
                for(int k=y1+1; k<y2; k++) {
                    map[j][k] = 0;
                }
            }
        }
        answer = bfs(new Node(characterX*2, characterY*2, 0), new Node(itemX*2, itemY*2, 0));
        return answer;
    }
    public int bfs(Node node, Node end) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited[node.x][node.y] = true;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            if (end.x == cur.x && end.y == cur.y) {
                return cur.distance/2;
            }
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if ((nx<0 || ny<0) || (nx>=102 || ny>=102)) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    q.add(new Node(nx, ny, cur.distance+1));
                    visited[nx][ny] = true;
                }
            }
        }
        return 0;
    }
    public class Node {
        int x;
        int y;
        int distance;
        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}