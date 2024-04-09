import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 나머지 합
public class Main {
    static int[] A;
    static int[] cA;
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        A = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        // two pointer 알고리즘
        int partial_sum = A[0];
        int start = 0, end = 1;
        int answer = N+1;

        while(end <= N){
            if(partial_sum < S){
                partial_sum += A[end];
                end++;
            }
            else{
                if(end - start < answer){
                    answer = end - start;
                }
                partial_sum -= A[start];
                start++;
            }
        }
        if(answer == N+1){
            sb.append(0);
        }
        else{
            sb.append(answer);
        }
        System.out.print(sb);
    }

    public static void main(String args[]) throws Exception {
        solution();
    }
}