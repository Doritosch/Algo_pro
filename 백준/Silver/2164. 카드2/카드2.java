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
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            q.add(i);
        }

        while(q.size() != 1) {
            q.poll();
            int card = q.poll();
            q.add(card);
        }
        System.out.println(q.poll());
    }
}