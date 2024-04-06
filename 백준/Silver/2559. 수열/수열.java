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
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        A = new int[N];
        cA = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            cA[i+1] = cA[i] + A[i];
        }
        
        answer = cA[K] - cA[0];

        for(int i = 1; i <= N-K; i++){
            if(cA[K+i]-cA[i] > answer) answer = cA[K+i] - cA[i];
        }

        sb.append(answer).append("\n");
        System.out.print(sb);

    }
    public static void main(String args[]) throws Exception {
        solution();
    }
}