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
        int count = 0;

        A = new int[N+1];
        cA = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++){
            A[i-1] = Integer.parseInt(st.nextToken());
            cA[i] = cA[i-1] + A[i-1];
        }

        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < i; j++){
                if(cA[i] - cA[j] == M){
                    count++;
                }
            }
        }
        sb.append(count);
        System.out.print(sb);
    }
    public static void cumulative(int M){
    }
    public static void main(String args[]) throws Exception {
        solution();
    }
}