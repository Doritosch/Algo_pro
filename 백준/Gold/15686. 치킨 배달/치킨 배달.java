import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

class Main
{
    static int n,m;
    static int answer;
    static int[][] board;
    static Node[] ch;
    static ArrayList<Node> chicken;
    static ArrayList<Node> house;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        ch = new Node[m];
        answer = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if ( board[i][j] == 1 ) {
                    house.add(new Node(i, j));
                }
                if ( board[i][j] == 2 ) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }
    public static void dfs(int at, int depth) {
        if ( depth == m ) {
            answer = Math.min(answer, getDistance());
            return;
        }

        if ( at >= chicken.size() ) {
            return;
        }

        for(int i=at; i<chicken.size(); i++) {
            ch[depth] = chicken.get(i);
            dfs(i+1, depth+1);
            dfs(i+1, depth);
        }
    }
    public static int getDistance() {
        int result = 0;

        for(int i=0; i<house.size(); i++) {
            int minDistance = Integer.MAX_VALUE;
            int x = house.get(i).x;
            int y = house.get(i).y;
            for(int j=0; j<m; j++) {
                int cx = ch[j].x;
                int cy = ch[j].y;
                int distance = Math.abs(x-cx) + Math.abs(y-cy);
                minDistance = Math.min(minDistance, distance);
            }
            result += minDistance;
        }
        return result;
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