import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {

    static char[][] field;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Node> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        field = new char[12][6];
        visited = new boolean[12][6];
        int result = 0;
        for(int i=0; i<12; i++) {
            String[] inputLine = br.readLine().split("");
            for(int j=0; j<6; j++) {
                field[i][j] = inputLine[j].charAt(0);
            }
        }

        while(true) {
            boolean check = false;
            visited = new boolean[12][6];

            for(int i=0; i<12; i++) {
                for(int j=0; j<6; j++) {
                    if ( field[i][j] != '.' && !visited[i][j] ) {
                        list = new ArrayList<>();
                        bfs(i, j);
                        if ( list.size()>=4 ) {
                            for(int k=0; k<list.size(); k++) {
                                Node node = list.get(k);
                                field[node.x][node.y] = '.';
                            }
                            check = true;
                        }
                    }
                }
            }

            if ( check ) {
                downBlock();
                result++;
            } else {
                break;
            }
        }
        System.out.println(result);
    }
    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(x,y));
        list.add(new Node(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Node node = q.poll();

            for(int i=0; i<4; i++) {
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;

                if ( (nx>=0 && ny>=0) && (nx<12 && ny<6) ) {
                    if ( field[nx][ny]==field[x][y] && !visited[nx][ny] ) {
                        q.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                        list.add(new Node(nx, ny));
                    }
                }
            }
        }
    }
    public static void downBlock() {
        for(int i=0; i<6; i++) {
            for(int j=11; j>=0; j--) {
                if ( field[j][i] == '.' ) {
                    for(int k=j-1; k>=0; k--) {
                        if ( field[k][i] != '.' ) {
                            field[j][i] = field[k][i];
                            field[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}