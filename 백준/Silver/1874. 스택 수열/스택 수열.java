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
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack(n);
        int[] data = new int[n];

        int count = 1;
        for(int i=0; i<n; i++) {
            data[i] = Integer.parseInt(br.readLine());

            while (data[i] != stack.peek() ) {
                if ( count > n ) {
                    System.out.println("NO");
                    return;
                }
                sb.append(stack.push(count++)).append("\n");
            }

            sb.append(stack.pop()).append("\n");
        }

        System.out.println(sb.toString());
    }

    static class Stack {
        private int[] dat;
        private int pos;

        public Stack(int n) {
            dat = new int[n];
            pos = -1;
        }

        public String push(int n) {
            dat[++pos] = n;
            return "+";
        }

        public String pop() {
            if ( isEmpty() ) {
                return "";
            }
            pos--;
            return "-";
        }

        public int peek() {
            if ( isEmpty() ) {
                return -1;
            }
            return dat[pos];
        }
        public boolean isEmpty() {
            if ( pos == -1 ) {
                return true;
            } else {
                return false;
            }
        }
    }
}