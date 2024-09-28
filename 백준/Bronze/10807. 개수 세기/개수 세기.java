import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int count = 0;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] array = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int value = Integer.parseInt(st.nextToken());
            array[i] = value;
        }

        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            if(array[i] == v) count ++;
        }

        sb.append(count);
        System.out.print(sb.toString());
    }
}
