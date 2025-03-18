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
        Deque deque = new Deque(n);

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            String pos = st.nextToken();
            if ( pos.equals("front")) {
                sb.append(deque.getFront());
            } else if ( pos.equals("back") ) {
                sb.append(deque.getBack());
            } else if ( pos.equals("size") ) {
                sb.append(deque.size());
            } else if ( pos.equals("empty") ) {
                sb.append(deque.isEmpty());
            } else if ( pos.equals("pop_front") ) {
                sb.append(deque.popFront());
            } else if ( pos.equals("pop_back") ) {
                sb.append(deque.popBack());
            } else if ( pos.equals("push_back") ) {
                int num = Integer.parseInt(st.nextToken());
                deque.pushBack(num);
                continue;
            } else if ( pos.equals("push_front") ) {
                int num = Integer.parseInt(st.nextToken());
                deque.pushFront(num);
                continue;
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static class Deque {
        private int[] deque;
        private int front;
        private int rear;
        private int capacity;

        public Deque(int n) {
            this.deque = new int[n + 1]; // 원형 큐는 1칸 더 크게 잡아야 함
            this.front = 0;
            this.rear = 0;
            this.capacity = n + 1;
        }

        public void pushFront(int n) {
            if (size() == capacity - 1) {
                return; // 덱이 가득 참
            }
            front = (front - 1 + capacity) % capacity;
            deque[front] = n;
        }

        public void pushBack(int n) {
            if (size() == capacity - 1) {
                return; // 덱이 가득 참
            }
            deque[rear] = n;
            rear = (rear + 1) % capacity;
        }

        public int popFront() {
            if (isEmpty() == 1) {
                return -1;
            }
            int val = deque[front];
            front = (front + 1) % capacity;
            return val;
        }

        public int popBack() {
            if (isEmpty() == 1) {
                return -1;
            }
            rear = (rear - 1 + capacity) % capacity;
            return deque[rear];
        }

        public int size() {
            return (rear - front + capacity) % capacity;
        }

        public int isEmpty() {
            return size() == 0 ? 1 : 0;
        }

        public int getFront() {
            if (isEmpty() == 1) {
                return -1;
            }
            return deque[front];
        }

        public int getBack() {
            if (isEmpty() == 1) {
                return -1;
            }
            return deque[(rear - 1 + capacity) % capacity];
        }
    }

}