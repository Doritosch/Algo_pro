import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        int answer=0;

        for(int i=0; i<N; i++) {
            int score = Integer.parseInt(br.readLine());
            scores[i] = score;
        }

        for(int i=N-1; i>0; i--) {
            if(scores[i]<=scores[i-1]) {
                answer += scores[i-1] - scores[i] + 1;
                scores[i-1] = scores[i] - 1;
            }
        }

        sb.append(answer);
        System.out.print(sb.toString());
    }
}