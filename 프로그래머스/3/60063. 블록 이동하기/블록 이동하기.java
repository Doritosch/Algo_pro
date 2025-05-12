import java.util.*;

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Set<String> set;
    static int n;
    public int solution(int[][] board) {
        set = new HashSet<>();
        n = board.length;
    
        return bfs(board);
    }
    public int bfs(int[][] board) {
        Queue<Robot> q = new LinkedList<>();
        
        Robot start = new Robot(0, 0, 0, 1, 0);
        q.add(start);
        
        while(!q.isEmpty()) {
            Robot cur = q.poll();
            
            if ( (cur.x1 == n-1 && cur.y1 == n-1) || (cur.x2 == n-1 && cur.y2 == n-1) ) {
                return cur.cost;
            }
            for(int i=0; i<4; i++) {
                int nx1 = cur.x1 + dx[i];
                int ny1 = cur.y1 + dy[i];
                int nx2 = cur.x2 + dx[i];
                int ny2 = cur.y2 + dy[i];
                
                Robot nr = new Robot(nx1, ny1, nx2, ny2, cur.cost+1);
                if ( isValid(nx1, ny1, board) && isValid(nx2, ny2, board) && !set.contains(nr.toString()) ) {
                    set.add(nr.toString());
                    q.add(nr);
                } 
            }
            
            if ( cur.x1 == cur.x2 ) {   // 가로
                for(int i=-1; i<=1; i+=2) {
                    if ( isValid(cur.x1+i, cur.y1, board) && isValid(cur.x2+i, cur.y2, board) ) {
                        Robot nr1 = new Robot(cur.x1+i, cur.y1, cur.x1, cur.y1, cur.cost+1);
                        Robot nr2 = new Robot(cur.x2+i, cur.y2, cur.x2, cur.y2, cur.cost+1);
                        if ( !set.contains(nr1.toString()) ) {
                            q.add(nr1);
                            set.add(nr1.toString());
                        }
                        if ( !set.contains(nr2.toString()) ) {
                            q.add(nr2);
                            set.add(nr2.toString());
                        }
                    }
                }
            } else {    // 세로
                for(int i=-1; i<=1; i+=2) {
                    if ( isValid(cur.x1, cur.y1+i, board) && isValid(cur.x2, cur.y2+i, board)) {
                        Robot nr1 = new Robot(cur.x1, cur.y1, cur.x1, cur.y1+i, cur.cost+1);
                        Robot nr2 = new Robot(cur.x2, cur.y2, cur.x2, cur.y2+i, cur.cost+1);
                        if ( !set.contains(nr1.toString()) ) {
                            q.add(nr1);
                            set.add(nr1.toString());
                        }
                        if ( !set.contains(nr2.toString()) ) {
                            q.add(nr2);
                            set.add(nr2.toString());
                        }
                    }
                }
            }
        }
        return -1;
    }
    public boolean isValid(int x, int y, int[][] board) {
        if ( (x>=0 && y>=0) && (x<n && y<n) ) {
            if ( board[x][y] == 0 ) {
                return true;
            }
        }
        return false;
    }
    public class Robot {
        int x1;
        int y1;
        int x2;
        int y2;
        int cost;
        public Robot(int x1, int y1, int x2, int y2, int cost) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.cost = cost;
        }
        public String toString() {
            if ( x1 > x2 || (x1==x2 && y1>y2)) {
                return x2 + "," + y2 + "," + x1 + "," + y1;
            } 
            return x1 + "," + y1 + "," + x2 + "," + y2;
        }
    }
}