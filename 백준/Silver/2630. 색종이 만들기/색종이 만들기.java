import java.util.*;
import java.io.*;


public class Main {
    static int[][] map;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        answer = new int[2];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(new Node(0,0), new Node(n,n));

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
    public static void divide(Node n1, Node n2) {

        if (isValidColor(n1, n2)) {
            return;
        }

        // 유효하지 않으면 4등분
        int midX = (n1.x+n2.x)/2;
        int midY = (n1.y+n2.y)/2;

        // 4분할
        divide(new Node(n1.x, n1.y), new Node(midX, midY)); // 좌상
        divide(new Node(midX, n1.y), new Node(n2.x, midY)); // 우상
        divide(new Node(n1.x, midY), new Node(midX, n2.y)); // 좌하
        divide(new Node(midX, midY), new Node(n2.x, n2.y)); // 우하
    }
    public static boolean isValidColor(Node n1, Node n2) {
        int color = map[n1.x][n1.y];
        for(int i=n1.x; i<n2.x; i++) {
            for(int j=n1.y; j<n2.y; j++) {
                if (color != map[i][j]) {
                    return false;
                }
            }
        }
        answer[map[n1.x][n1.y]] += 1;
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
