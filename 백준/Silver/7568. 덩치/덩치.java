import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            people[i][0] = weight;
            people[i][1] = height;
        }

        int[] ranks = new int[N];
        Arrays.fill(ranks, 1);
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(i!=j&&people[i][0]<people[j][0]&&people[i][1]<people[j][1]) {
                    ranks[i]++;
                }
            }
        }

        for(int i=0; i<N; i++) {
            sb.append(ranks[i]).append(" ");
        }

        System.out.print(sb.toString());
    }
}