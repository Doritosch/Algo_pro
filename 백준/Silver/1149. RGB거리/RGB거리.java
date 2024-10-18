import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = findMin(house);
        sb.append(answer);

        System.out.print(sb.toString());
    }

    public static int findMin(int[][] house) {
        int[][] dp = new int[house.length][3];

        for(int i=1; i<house.length; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
        }

        return Math.min(Math.min(dp[dp.length-1][0], dp[dp.length-1][1]), dp[dp.length-1][2]);
    }
}