import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n<2) {
                sb.append(1).append("\n");
                continue;
            }
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            for(int j=3; j<=n; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
