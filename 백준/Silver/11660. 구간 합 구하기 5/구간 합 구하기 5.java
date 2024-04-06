import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 나머지 합
public class Main {
    static int[][] A;
    static int[][] cA;
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        cA = new int[N+1][N+1];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                cA[i+1][j+1] = cA[i][j+1] + cA[i+1][j] - cA[i][j] + A[i][j];
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int answer = cA[x2][y2] - cA[x1-1][y2] - cA[x2][y1-1] + cA[x1-1][y1-1];
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String args[]) throws Exception {
        solution();
    }
}