import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] checked = new boolean[(int) (max - min + 1)];
        for(long i=2; i*i<=max; i++) {
            long pow = i*i;
            long startIdx = min/pow;
            if (min%pow != 0) {
                startIdx++;
            }
            for(long j=startIdx; pow*j<=max; j++) {
                checked[(int)((j*pow)-min)] = true;
            }
        }
        int count = 0;
        for(int i=0; i<=max-min; i++) {
            if (!checked[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}