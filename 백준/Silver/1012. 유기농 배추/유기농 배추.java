import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0 ,-1};
    public static void countBugField(int[][] field, boolean[][] visited, int s1, int s2) {

        for(int i=0; i<4; i++) {
            int nx = dx[i] + s1;
            int ny = dy[i] + s2;

            if((nx>=0 && nx < field[0].length) && (ny>=0 && ny < field.length)) {
                if(field[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    countBugField(field, visited, nx, ny);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] field = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            int count = 0;

            for(int j=0; j<K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                field[Y][X] = 1;
            }

            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    if(field[j][k] == 1 && !visited[j][k]) {
                        countBugField(field, visited, k, j);
                        count += 1;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb.toString());
    }
}