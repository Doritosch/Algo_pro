import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append(" ");

            int[] height = new int[20];
            for(int j=0; j<20; j++) {
                height[j] = Integer.parseInt(st.nextToken());
            }

            sb.append(solve(height)).append("\n");
        }

        System.out.print(sb.toString());
    }
    private static int solve(int[] height) {
        int count = 0;
        for(int i=1; i<height.length; i++) {
            for(int j=i; j>0; j--) {
                if(height[j]<height[j-1]) {
                    swap(height, j, j-1);
                    count++;
                }
            }
        }
        return count;
    }
    private static void swap(int[] arr, int i, int j) {
        int value = arr[i];
        arr[i] = arr[j];
        arr[j] = value;
    }
}