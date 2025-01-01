import java.io.*;
import java.nio.Buffer;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        int[] time = new int[100001];

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = true;

        while(!q.isEmpty()) {
            int value = q.poll();

            if(value == K) {
                sb.append(time[value]);
                break;
            }
            if(value-1 >= 0 && !visited[value-1]) {
                q.add(value-1);
                visited[value-1] = true;
                time[value-1] = time[value]+1;
            }
            if(value+1 < 100001 && !visited[value+1]) {
                q.add(value + 1);
                visited[value+1] = true;
                time[value +1] = time[value]+1;
            }
            if(value*2 < 100001 && !visited[value*2]) {
                q.add(value *2);
                visited[value*2] = true;
                time[value *2] = time[value]+1;
            }
        }

        System.out.print(sb.toString());
    }
}