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

        int[] baskets = new int[N];
        for(int i=0; i< baskets.length; i++) {
            baskets[i] = i+1;
        }

        for(int p=0; p<M; p++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int temp = baskets[i-1];
            baskets[i-1] = baskets[j-1];
            baskets[j-1] = temp;
        }

        for(int i=0; i<baskets.length; i++) {
            sb.append(baskets[i]).append(" ");
        }

        System.out.print(sb.toString());
    }
}
