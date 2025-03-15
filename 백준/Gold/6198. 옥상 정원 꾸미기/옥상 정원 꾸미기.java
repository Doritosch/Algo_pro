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

        // 빌딩의 개수는 <= 80,000 이므로 O(n^2) 까지 고려해도 된다.
        int n = Integer.parseInt(br.readLine());
        Stack<Pair> stack = new Stack<>();
        long answer = 0;
        // 1. 자신이 위치한 빌딩보다 높거나 같은 빌딩이 있으면 그 다음에 있는 모든 빌딩의 옥상은 보지 못한다.
        // 10 = 0
        // 10 3 = 1
        // 10 7 = 2
        // 10 7 4 = 4
        // 12 = 4
        // 2 = 5
        for(int i=0; i<n; i++) {
            int h = Integer.parseInt(br.readLine());

            while( !stack.isEmpty() && stack.peek().height <= h) {
                stack.pop();
            }

            answer += stack.size();
            stack.push(new Pair(i, h));
        }

        System.out.println(answer);
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