import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

class Main
{
    static int[] floor;
    static int u, d;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        floor = new int[f+1];

        bfs(s, f);

        if ( s==g ) {
            System.out.println(0);
        } else {
            if ( floor[g] == 0 ) {
                System.out.println("use the stairs");
            } else {
                System.out.println(floor[g]);
            }
        }
    }
    static void bfs(int s, int f) {
        Queue<Integer> q = new LinkedList<>();

        q.add(s);

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i=0; i<2; i++) {
                int us = cur + u;
                int ds = cur - d;

                if ( us <= f && u != 0 ) {
                    if ( floor[us] == 0 ) {
                        q.add(us);
                        floor[us] = floor[cur] + 1;
                    }
                }
                if ( ds >=1 && d != 0 ) {
                    if ( floor[ds] == 0 ) {
                        q.add(ds);
                        floor[ds] = floor[cur] + 1;
                    }
                }
            }
        }
    }
}