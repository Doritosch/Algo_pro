import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 나머지 합
public class Main {
    static int[][] A;
    static int[][] cA;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        cA = new int[N+1][M+1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                cA[i+1][j+1] = cA[i+1][j] + cA[i][j+1] - cA[i][j] + A[i][j];
            }
        }

        int K = Integer.parseInt(br.readLine());

        for(int p = 0; p < K; p++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(cA[x][y] - cA[x][j-1] - cA[i-1][y] + cA[i-1][j-1]).append("\n");
        }
        System.out.print(sb);
    }
    public static void main(String args[]) throws Exception {
        solution();
    }
}