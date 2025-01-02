import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        String[] s = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            sequence[i] = Integer.parseInt(s[i]);
        }

        for(int i=1; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(sequence[i]>sequence[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            if(dp[i]>answer) answer = dp[i];
        }

        sb.append(answer);
        System.out.print(sb.toString());
    }
}