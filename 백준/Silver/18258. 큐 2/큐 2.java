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
        Queue q = new Queue(n);

        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());

            String pos = st.nextToken();

            if ( pos.equals("front")) {
                sb.append(q.peekFront());
            } else if ( pos.equals("back") ) {
                sb.append(q.peekBack());
            } else if ( pos.equals("size")) {
                sb.append(q.size());
            } else if ( pos.equals("empty") ) {
                sb.append(q.isEmpty());
            } else if ( pos.equals("pop") ) {
                sb.append(q.pop());
            } else {
                int num = Integer.parseInt(st.nextToken());
                q.push(num);
                continue;
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static class Queue {
        private int[] dat;
        private int front;
        private int back;

        public Queue(int n) {
            this.dat = new int[n];
            this.front = 0;
            this.back = 0;
        }

        public void push(int x) {
            dat[back++] = x;
        }

        public int pop() {
            if ( isEmpty() == 1 ) {
                return -1;
            }
            return dat[front++];
        }

        public int size() {
            return back-front;
        }

        public int isEmpty() {
            if ( size() == 0 ) {
                return 1;
            } else {
                return 0;
            }
        }

        public int peekFront() {
            if ( isEmpty() == 1 ) {
                return -1;
            }
            return dat[front];
        }

        public int peekBack() {
            if ( isEmpty() == 1 ) {
                return -1;
            }
            return dat[back-1];
        }
    }
}