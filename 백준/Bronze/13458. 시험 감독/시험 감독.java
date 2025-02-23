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
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] candidate = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            candidate[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long answer = 0;
        for(int i=0; i<n; i++) {
            candidate[i] -= b;
            answer++;

            if(candidate[i]>0) {
                if(candidate[i]%c==0) {
                    answer += (candidate[i]/c);
                } else {
                    answer += (candidate[i]/c+1);
                }
            }
        }

        System.out.println(answer);
    }
}