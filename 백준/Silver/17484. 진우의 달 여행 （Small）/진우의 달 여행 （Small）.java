import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];
        int[][][] dp = new int[N][M][3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(i==0) {
                    Arrays.fill(dp[i][j], matrix[i][j]);
                } else {
                    Arrays.fill(dp[i][j], Integer.MAX_VALUE);
                }
            }
        }

        for(int i=1; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(j!=0) dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + matrix[i][j];
                dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + matrix[i][j];
                if(j!=M-1) dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + matrix[i][j];
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=0; i<M; i++) {
            for(int j=0; j<3; j++) {
                result = Math.min(result, dp[N-1][i][j]);
            }
        }

        sb.append(result);
        System.out.print(sb.toString());
    }
}