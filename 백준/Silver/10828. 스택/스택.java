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

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            String pos = st.nextToken();

            if ( pos.equals("top") ) {
                sb.append(stack.top()).append("\n");
            } else if ( pos.equals("empty") ) {
                sb.append(stack.empty()).append("\n");
            } else if ( pos.equals("size") ) {
                sb.append(stack.size()).append("\n");
            } else if ( pos.equals("pop") ) {
                sb.append(stack.pop()).append("\n");
            } else {
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);

            }
        }
        System.out.println(sb.toString());
    }

    static class Stack {
        private int[] stack;
        private int count;

        public Stack(int n) {
            this.stack = new int[n];
            this.count = -1;
        }

        public void push(int n) {
            stack[++count] = n;
        }

        public int pop() {
            if ( count == -1 ) {
                return -1;
            }

            int popNumber = stack[count];
            stack[count] = 0;
            count--;
            return popNumber;
        }

        public int size() {
            return count+1;
        }

        public int empty() {
            if ( count == -1 ) {
                return 1;
            } else {
                return 0;
            }
        }

        public int top() {
            if ( count == -1 ) {
                return -1;
            }
            return stack[count];
        }
    }
}