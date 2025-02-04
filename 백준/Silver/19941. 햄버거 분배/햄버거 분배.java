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
        int K = Integer.parseInt(st.nextToken());
        String[] line = br.readLine().split("");
        boolean[] check = new boolean[N];
        int count = 0;
        for(int i=0; i<N; i++) {
            if(line[i].equals("P")) {
                for(int j=i-K; j<=i+K; j++) {
                    if(j>=0 && j<N) {
                        if(line[j].equals("H") && !check[j]) {
                            check[j] = true;
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        sb.append(count);
        System.out.print(sb.toString());
    }
}