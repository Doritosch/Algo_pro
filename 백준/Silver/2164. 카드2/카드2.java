import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> card = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            card.add(i);
        }

        while(card.size() != 1) {
            card.poll();

            int num = card.poll();
            card.add(num);
        }

        sb.append(card.poll());
        System.out.print(sb.toString());
    }
}