import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 나머지 합
public class Main {
    static int[] A;
    static int[] cA;
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new int[N+1];
        cA = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= N; i++){
            cA[i] = cA[i-1] + A[i-1];
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(cumulative(start, end)).append("\n");
        }

        System.out.print(sb);

    }
    public static int cumulative(int start, int end){
        return cA[end] - cA[start-1];
    }
    public static void main(String args[]) throws Exception {
        solution();
    }
}