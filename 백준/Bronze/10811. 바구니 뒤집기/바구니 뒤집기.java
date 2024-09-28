import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] baskets = new int[N+1];

        for(int i=1; i<baskets.length; i++) {
            baskets[i] = i;
        }

        for(int p=0; p<M; p++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            while(i<j) {
                int temp = baskets[i];
                baskets[i] = baskets[j];
                baskets[j] = temp;
                
                i++;
                j--;
            }
        }

        for(int i=1; i<baskets.length; i++) {
            sb.append(baskets[i]).append(" ");
        }

        System.out.print(sb.toString());
    }
}
