import java.util.*;
import java.io.*;

public class Main {
    static int[][] field;

    static Queue<Node> dustQ;
    static Node[] cleaner;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        field = new int[r][c];

        dustQ = new LinkedList<>();
        cleaner = new Node[2];
        int cleanerIdx = 0;

        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                if (field[i][j] == -1) {
                    cleaner[cleanerIdx++] = new Node(i,j,0);
                }
            }
        }

        for(int i=0; i<t; i++) {
            collectDust();  // 미세먼지 저장
            spreadDust();   // 미세먼지 확산
            runCleaner();   // 공기청정기 작동
        }

        System.out.println(countDust());
    }
    static void spreadDust() {
        while(!dustQ.isEmpty()) {
            Node cur = dustQ.poll();

            int count = checkDirection(cur);
            int dust = cur.value/5;
            field[cur.x][cur.y] -= (dust*count);

            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (isValidDriection(nx, ny)) {
                    field[nx][ny] += dust;
                }
            }
        }
    }
    static int checkDirection(Node node) {
        int count = 0;

        for(int i=0; i<4; i++) {
            int nx = node.x + dx[i];
            int ny = node.y + dy[i];

            if (isValidDriection(nx, ny)) {
                count += 1;
            }
        }
        return count;
    }
    static boolean isValidDriection(int nx, int ny) {
        if ((nx<0||ny<0) || (nx>=field.length||ny>=field[0].length)) {
            return false;
        }

        if (field[nx][ny] == -1) {
            return false;
        }
        return true;
    }
    static void collectDust() {
        for(int i=0; i<field.length; i++) {
            for(int j=0; j<field[0].length; j++) {
                if (field[i][j]/5 != 0) {
                    dustQ.add(new Node(i,j, field[i][j]));
                }
            }
        }
    }
    static void runCleaner() {
        Node upCleaner = cleaner[0];
        Node downCleaner = cleaner[1];

        for(int i=upCleaner.x-1; i>0; i--) field[i][0] = field[i-1][0];
        for(int i=0; i<field[0].length-1; i++) field[0][i] = field[0][i+1];
        for(int i=0; i<upCleaner.x; i++) field[i][field[0].length-1] = field[i+1][field[0].length-1];
        for(int i=field[0].length-1; i>1; i--) field[upCleaner.x][i] = field[upCleaner.x][i-1];
        field[upCleaner.x][1] = 0;

        for(int i=downCleaner.x+1; i<field.length-1; i++) field[i][0] = field[i+1][0];
        for(int i=0; i<field[0].length-1; i++) field[field.length-1][i] = field[field.length-1][i+1];
        for(int i=field.length-1; i>downCleaner.x; i--) field[i][field[0].length-1] = field[i-1][field[0].length-1];
        for(int i=field[0].length-1; i>1; i--) field[downCleaner.x][i] = field[downCleaner.x][i-1];
        field[downCleaner.x][1] = 0;
    }
    static int countDust() {
        int sum = 0;
        for(int i=0; i<field.length; i++) {
            for(int j=0; j<field[0].length; j++) {
                if (field[i][j] > 0) {
                    sum += field[i][j];
                }
            }
        }
        return sum;
    }
    static class Node {
        int x;
        int y;
        int value;
        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
