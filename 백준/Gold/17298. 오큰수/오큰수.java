import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        Stack<Pair> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());

            while( !stack.isEmpty() && stack.peek().num < num ) {
                Pair pair = stack.pop();
                nums[pair.index] = num;
            }
            stack.push(new Pair(i, num));
        }

        for(int i=0; i<n; i++) {
            if ( nums[i] == 0 ) {
                sb.append(-1).append(" ");
            } else {
                sb.append(nums[i]).append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    static class Pair {
        private int index;
        private int num;

        public Pair(int index, int height) {
            this.index = index;
            this.num = height;
        }
    }
}