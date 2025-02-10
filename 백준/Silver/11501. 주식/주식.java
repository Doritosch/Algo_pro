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

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] stocks = new int[n];
            if(n==0) {
                sb.append(0).append("\n");
                continue;
            }

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                stocks[j] = Integer.parseInt(st.nextToken());
            }

            long result = 0;
            int max = stocks[n-1];
            for(int j=n-2; j>=0; j--) {
                if(max<stocks[j]) {
                    max = stocks[j];
                } else {
                    result = result + max - stocks[j];
                }
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb.toString());
    }
}