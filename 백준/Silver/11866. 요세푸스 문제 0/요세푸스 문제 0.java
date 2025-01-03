import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            list.add(i);
        }

        sb.append("<");

        int index = 0;
        while(list.size() > 1) {
            index = (index + (K-1)) % list.size();

            sb.append(list.remove(index)).append(", ");
        }
        sb.append(list.remove(0)).append(">");

        System.out.print(sb.toString());
    }
}