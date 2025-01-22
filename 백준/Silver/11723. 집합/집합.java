import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[] set = new boolean[21];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String cal = st.nextToken();
            if(cal.equals("all")) {
                Arrays.fill(set, true);
                continue;
            }
            else if(cal.equals("empty")) {
                Arrays.fill(set, false);
                continue;
            }
            int num = Integer.parseInt(st.nextToken());

            if(cal.equals("add")) {
                set[num] = true;
            }
            else if(cal.equals("remove")) {
                set[num] = false;
            }
            else if(cal.equals("check")) {
                if(set[num]) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
            else if(cal.equals("toggle")) {
                if(set[num]) {
                    set[num] = false;
                } else {
                    set[num] = true;
                }
            }
        }
        System.out.print(sb.toString());
    }
}