import java.util.*;
class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] visited;
    
    public int solution(String[] maps) {
        int answer = 0;
        visited = new int[maps.length][maps[0].length()];
        
        Node start = getStart(maps);
        
        Node lever = bfs(start, maps, 'L');
        if ( lever == null ) {
            return -1;
        }

        answer += visited[lever.x][lever.y];
        visited = new int[maps.length][maps[0].length()];
        
        Node exit = bfs(lever, maps, 'E');
        if ( exit == null ) {
            return -1;
        }
        answer += visited[exit.x][exit.y];
        
        return answer;
    }
    public Node getStart(String[] maps) {
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                if ( maps[i].charAt(j) == 'S' ) {
                    return new Node(i,j);
                }
            }
        }
        return null;
    }
    public Node bfs(Node start, String[] maps, char target) {
        Queue<Node> q = new LinkedList<>();
        
        q.add(start);
        
        while(!q.isEmpty()) {
            Node curPos = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = curPos.x + dx[i];
                int ny = curPos.y + dy[i];
                
                if ( (nx>=0 && ny >=0) && (nx<maps.length && ny<maps[0].length()) ){
                    if ( visited[nx][ny]==0 && maps[nx].charAt(ny) != 'X') {
                        visited[nx][ny] = visited[curPos.x][curPos.y] + 1;
                        if ( maps[nx].charAt(ny)==target ) {
                            return new Node(nx, ny);
                        }  
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
        return null;
    }
    
    public class Node{
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}