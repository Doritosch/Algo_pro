import java.util.*;
class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);
        
        for(int i=0; i<places.length; i++) {
            String[] room = places[i];
            for(int j=0; j<room.length; j++) {
                for(int k=0; k<room[0].length(); k++) {
                    if ( room[j].charAt(k) == 'P' ) {
                        visited = new boolean[room.length][room[0].length()];
                        if ( !findParticipants(j, k, room) ) {
                            answer[i] = 0;
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
    public boolean findParticipants(int x, int y, String[] room) {
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(x,y));
        visited[x][y] = true;
        while(!q.isEmpty()) {
            Node curPos = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = curPos.x + dx[i];
                int ny = curPos.y + dy[i];
                
                if ( (nx>=0 && ny>=0) && (nx<room.length && ny<room[0].length())) {
                    int distance = Math.abs(x-nx) + Math.abs(y-ny);
                    if ( !visited[nx][ny] && room[nx].charAt(ny) != 'X' ) {
                        if ( distance <= 2 ) {
                            if ( room[nx].charAt(ny) == 'P' ) {
                                return false;
                            }
                            visited[nx][ny] = true;
                            q.add(new Node(nx, ny));
                        }
                    }
                }
            }
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