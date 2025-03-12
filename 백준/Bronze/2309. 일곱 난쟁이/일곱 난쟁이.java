import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] height = new int[9];
        boolean[] checked = new boolean[9];
        int sum = 0;
        for(int i=0; i<9; i++) {
            int n = Integer.parseInt(br.readLine());
            sum += n;
            height[i] = n;
        }

        Arrays.sort(height);
        checked = check(checked, height, sum);

        for(int i=0; i<9; i++) {
            if (!checked[i]) {
                sb.append(height[i]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static boolean[] check(boolean[] checked, int[] height, int sum) {
        for(int i=0; i<height.length-1; i++) {
            for(int j=i+1; j<height.length; j++) {
                int heights = height[i] + height[j];

                if ( sum-heights == 100 ) {
                    checked[i] = true;
                    checked[j] = true;
                    return checked;
                }
            }
        }
        return checked;
    }
}