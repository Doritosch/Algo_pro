import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] tps = new int[N];

        String[] s = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            tps[i] = Integer.parseInt(s[i]);
        }

        sb.append(calMax(tps, K));
        System.out.print(sb.toString());
    }

    public static int calMax(int[] tps, int K) {
        int max = -1001;
        for(int i=0; i<=tps.length-K; i++) {
            int sum = 0;
            for(int j=i; j<i+K; j++) {
                sum += tps[j];
            }
            if(max<sum) max = sum;
        }
        return max;
    }
}