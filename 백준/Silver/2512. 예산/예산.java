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

        int N = Integer.parseInt(br.readLine());
        int[] budgets = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        sb.append(solve(budgets, M));
        System.out.print(sb.toString());
    }
    public static int solve(int[] budgets, int M) {
        int left = 0;
        int right = -1;

        for(int i=0; i<budgets.length; i++) {
            right = Math.max(right, budgets[i]);
        }

        while(left<=right) {
            int mid = (left+right)/2;

            long budget = 0;
            for(int i=0; i<budgets.length; i++) {
                if(budgets[i]>mid) {
                    budget+=mid;
                } else {
                    budget+=budgets[i];
                }
            }

            if(budget<=M) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return right;
    }
}