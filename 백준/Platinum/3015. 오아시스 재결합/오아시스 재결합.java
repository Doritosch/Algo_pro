import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

class Main
{
    /*두 사람 A와 B가 서로 볼 수 있으려면, 두 사람 사이에 A 또는 B보다 키가 큰 사람이 없어야 한다.

    줄에 서 있는 사람의 키가 주어졌을 때, 서로 볼 수 있는 쌍의 수를 구하는 프로그램을 작성하시오.*/
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Stack<Pair> stack = new Stack<>();
        long answer = 0;

        for(int i=0; i<n; i++) {
            int height = Integer.parseInt(br.readLine());

            int count = 1;
            while( !stack.isEmpty() && stack.peek().getHeight() < height ) {
                answer += stack.peek().getCount();
                stack.pop();
            }

            if ( !stack.isEmpty() && stack.peek().getHeight() == height ) {
                answer += stack.peek().getCount();
                count = stack.peek().getCount() + 1;
                stack.pop();
            }

            if ( !stack.isEmpty() ) {
                answer++;
            }

            stack.push(new Pair(height, count));
        }

        System.out.println(answer);
    }
    static class Pair {
        private int height;
        private int count;

        public Pair(int height, int count) {
            this.height = height;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public int getHeight() {
            return height;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}