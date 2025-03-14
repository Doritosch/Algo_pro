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
            int money = Integer.parseInt(br.readLine());

            if ( money == 0 ) {
                stack.pop();
            } else {
                stack.push(money);
            }
        }

        int answer = stack.sum();
        System.out.println(answer);
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

        public void pop() {
            if ( count == -1 ) {
                return;
            }
            stack[count--] = 0;
        }

        public int sum() {
            int sum = 0;
            for(int i=0; i<=count; i++) {
                sum += stack[i];
            }
            return sum;
        }
    }
}