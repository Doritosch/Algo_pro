import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    static int[] tile;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        tile = new int[N+1];

        sb.append(dp(N));
        System.out.print(sb.toString());
    }
    public static int dp(int N) {
        if(N==1) {
            return 1;
        }
        else if(N==2) {
            return 3;
        }
        tile[1] = 1;
        tile[2] = 3;
        for(int i=3; i<=N; i++) {
            tile[i] = (tile[i-1] + 2*tile[i-2]) % 10007;
        }
        return tile[N];
    }
}