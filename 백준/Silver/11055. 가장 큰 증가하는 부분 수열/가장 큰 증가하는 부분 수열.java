import java.awt.*;
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] dp = new int[N];

        String[] s = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(s[i]);
        }

        int max = 0;
        for(int i=0; i<N; i++) {
            dp[i] = numbers[i];
            for(int j=0; j<i; j++) {
                if((numbers[j]<numbers[i])&&(dp[i]<dp[j]+numbers[i])) {
                    dp[i] = dp[j] + numbers[i];
                }
            }
            if(max<dp[i]) max = dp[i];
        }
        sb.append(max);
        System.out.print(sb.toString());
    }
}