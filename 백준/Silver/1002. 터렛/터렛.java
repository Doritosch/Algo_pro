import java.util.*;
import java.io.*;


public class Main {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            if ((x1 == x2) && (y1 == y2)) {
                if (r1 == r2) {
                    System.out.println(-1);
                } else {
                    System.out.println(0);
                }
            } else {
                long dist2 = (long)(x1 - x2) * (x1 - x2) + (long)(y1 - y2) * (y1 - y2);
                long sumR = (long)(r1 + r2) * (r1 + r2);
                long diffR = (long)(r1 - r2) * (r1 - r2);

                if (dist2 == sumR || dist2 == diffR) {
                    System.out.println(1); // 외접 또는 내접
                } else if (diffR < dist2 && dist2 < sumR) {
                    System.out.println(2); // 두 점에서 만남
                } else {
                    System.out.println(0); // 안 만남
                }
            }
        }
    }
}
