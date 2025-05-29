import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

class Main
{
    static String[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static boolean answer = false;
    static ArrayList<Node> teachers;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        board = new String[n][n];
        teachers = new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = st.nextToken();
                if ( board[i][j].equals("T") ) {
                    teachers.add(new Node(i, j));
                }
            }
        }

        dfs(0);

        if ( answer ) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    public static void dfs(int depth) {
        if ( depth == 3 ) {
            if ( isHide() ) {
                answer = true;
            }
            return;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if ( board[i][j].equals("X") ) {
                    board[i][j] = "O";
                    dfs(depth+1);
                    board[i][j] = "X";
                }
            }
        }
    }
    public static boolean isHide() {
        for(Node pos : teachers) {
            for(int i=0; i<4; i++) {
                Node cur = new Node(pos.x, pos.y);
                while(true) {
                    cur.x = cur.x + dx[i];
                    cur.y = cur.y + dy[i];

                    if ( (cur.x<0 || cur.x>=n) || (cur.y<0 || cur.y>=n) ) {
                        break;
                    }

                    if ( board[cur.x][cur.y].equals("O") ) {
                        break;
                    }

                    if ( board[cur.x][cur.y].equals("S") ) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}