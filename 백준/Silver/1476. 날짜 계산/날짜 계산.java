import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int year = 1;

        while(true) {
            if((year-E)%15==0 && (year-S)%28==0 && (year-M)%19==0) {
                break;
            }
            year+=1;
        }

        sb.append(year);
        System.out.print(sb.toString());
    }
}