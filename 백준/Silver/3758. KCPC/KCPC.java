import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T--!=0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] team = new int[n+1][k+1];
            int[] count = new int[n+1];
            int[] time = new int[n+1];
            
            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                team[id][j] = Math.max(team[id][j], s);
                time[id] = i;
                count[id]++;
            }

            int myScore = 0;
            for(int i=1; i<=k; i++) {
                myScore += team[t][i];
            }
            int rank = 1;
            for(int i=1; i<=n; i++) {
                if(i==t) continue;

                int sum = 0;
                for(int l=1; l<=k; l++) {
                    sum += team[i][l];
                }
                if(myScore<sum) {
                    rank++;
                }
                else if(myScore==sum) {
                    if(count[t]>count[i]) {
                        rank++;
                    }
                    else if(count[t]==count[i]) {
                        if(time[t]>time[i]) {
                            rank++;
                        }
                    }
                }
            }
            sb.append(rank).append("\n");
        }
        System.out.print(sb.toString());
    }
}