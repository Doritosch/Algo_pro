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

        st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        A = new int[N];
        cA = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            cA[i+1] = cA[i] + A[i];
        }

        int visit = 0;
        int count = 1;
        for(int i = X; i < N+1; i++){
            if(visit == cA[i] - cA[i-X]){
                count++;
            }
            if(cA[i] - cA[i-X] > visit){
                visit = cA[i] - cA[i-X];
                count = 1;
            }
        }

        if (visit==0){
            sb.append("SAD");
        }
        else{
            sb.append(visit).append("\n");
            sb.append(count);
        }
        System.out.print(sb);
    }

    public static void main(String args[]) throws Exception {
        solution();
    }
}