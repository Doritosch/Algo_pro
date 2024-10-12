import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int answer = countWays(n);

        sb.append(answer);
        System.out.print(sb.toString());
    }

    public static int countWays(int n) {
        if(n<3) {
            return n;
        }

        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }
        return dp[n];
    }
}