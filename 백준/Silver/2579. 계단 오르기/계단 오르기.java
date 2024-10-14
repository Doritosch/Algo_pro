import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] steps = new int[n+1];

        for(int i=1; i<=n; i++) {
            int step = Integer.parseInt(br.readLine());
            steps[i] = step;
        }

        int answer = calMaxSteps(steps, n);

        sb.append(answer);
        System.out.print(sb.toString());
    }

    public static int calMaxSteps(int[] steps, int n) {
        if(n==1) return steps[1];
        if(n==2) return steps[1]+steps[2];

        int[] dp = new int[n+1];
        dp[1] = steps[1];
        dp[2] = steps[1] + steps[2];
        dp[3] = Math.max(steps[3]+steps[2], steps[3]+steps[1]);
        for(int i=4; i<=n; i++) {
            dp[i] = Math.max(steps[i]+steps[i-1]+dp[i-3], steps[i]+dp[i-2]);
        }
        return dp[n];
    }
}