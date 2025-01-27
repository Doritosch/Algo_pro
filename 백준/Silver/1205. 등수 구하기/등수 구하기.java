import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N>0) {
            int[] scores = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(solve(scores, S, P));
        } else {
            sb.append(1);
        }

        System.out.print(sb.toString());
    }
    private static int solve(int[] scores, int S, int P) {
        if(scores.length==0) {
            return 1;
        }

        int rank = 1;

        for(int i=0; i<scores.length; i++) {
            if(scores[i] < S) {
                break;
            } else if(scores[i] > S){
                rank++;
            }
        }

        if(scores.length == P && scores[scores.length-1] >= S) {
            return -1;
        }
        return rank;
    }
}