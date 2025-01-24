import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] nations = new int[N][4];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            nations[i][0] = num;
            nations[i][1] = gold;
            nations[i][2] = silver;
            nations[i][3] = bronze;
        }

        sb.append(solve(nations, K));
        System.out.print(sb.toString());
    }
    private static int solve(int[][] nations, int K) {
        Arrays.sort(nations, (o1, o2) -> {
            if(o1[1]==o2[1]) {
                if(o1[2]==o2[2]) {
                    return o2[3]-o1[3];
                }
                return o2[2]-o1[2];
            }
            return o2[1]-o1[1];
        });

        int[] tempScore = {0, 0, 0};
        int rank = 0;
        for(int[] score:nations) {
            if(tempScore[0]!=score[1]||tempScore[1]!=score[2]||tempScore[2]!=score[3]) {
                tempScore[0] = score[1];
                tempScore[1] = score[2];
                tempScore[2] = score[3];
                rank++;
            }
            if(score[0]==K) {
                return rank;
            }
        }
        return rank;
    }
}