import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int maxY = 0;
        int maxIndex = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x] = y;
            start = Math.min(start, x);
            end = Math.max(end, x);
            if(maxY<y) {
                maxY = y;
                maxIndex = x;
            }
        }

        int result=0;
        int curY = arr[start];
        for(int i=start; i<maxIndex; i++) {
            curY = Math.max(curY, arr[i]);
            result += curY;
        }

        curY = arr[end];
        for(int i=end; i>maxIndex; i--) {
            curY = Math.max(curY, arr[i]);
            result += curY;
        }

        result += maxY;

        System.out.println(result);
    }
}