import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] A = new int[n];

        int start = 0;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (start<A[i]) {
                start = A[i];
            }
            end += A[i];
        }

        while(start<=end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;
            
            for(int i=0; i<n; i++) {
                if (sum + A[i] > mid) {
                    count += 1;
                    sum = 0;
                }
                sum += A[i];
            }

            if (sum != 0) {
                count += 1;
            }
            if (count>m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}
