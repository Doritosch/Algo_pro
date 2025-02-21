import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[10001];
        for(int i=0; i<=10000; i++) {
            dp[i] += 1;
        }
        for(int i=2; i<=10000; i++) {
            dp[i] += dp[i-2];
        }
        for(int i=3; i<=10000; i++) {
            dp[i] += dp[i-3];
        }

        for(int i=0; i<n; i++) {
            int value = Integer.parseInt(br.readLine());
            sb.append(dp[value]).append("\n");
        }
        System.out.println(sb.toString());
    }
}