import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] tv = new String[N];

        for(int i=0; i<N; i++) {
            tv[i] = br.readLine();
        }

        solve(tv);
        System.out.print(sb.toString());
    }
    public static void solve(String[] tv) {
        int point = 0;
        while(!tv[0].equals("KBS1")) {
            if(!tv[point].equals("KBS1")) {
                point++;
                sb.append(1);
            }
            else {
                String word = tv[point-1];
                tv[point-1] = tv[point];
                tv[point] = word;
                point--;
                sb.append(4);
            }
        }
        while(!tv[1].equals("KBS2")) {
            if(!tv[point].equals("KBS2")) {
                point++;
                sb.append(1);
            }
            else {
                String word = tv[point-1];
                tv[point-1] = tv[point];
                tv[point] = word;
                point--;
                sb.append(4);
            }
        }
    }
}