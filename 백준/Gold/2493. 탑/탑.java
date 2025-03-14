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
        Stack<Pair> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int height = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && height > stack.peek().height) {
                stack.pop();
            }

            if ( stack.isEmpty() ) {
                sb.append(0).append(" ");
            } else {
                sb.append(stack.peek().index).append(" ");
            }

            stack.push(new Pair(i+1, height));
        }

        System.out.println(sb.toString());
    }

    static class Pair {
        private int index;
        private int height;

        public Pair(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}