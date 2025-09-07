import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            map[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            map[e].add(s);
        }

        int max = 0;
        List<Integer> answer = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            boolean[] visited = new boolean[n+1];
            int count = bfs(i, visited);

            if (count > max) {
                max = count;
                answer = new ArrayList<>();
                answer.add(i);
            } else if (count == max) {
                answer.add(i);
            }
        }
        for(int value : answer) {
            System.out.print(value + " ");
        }
    }

    public static int bfs(int x, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        q.add(x);
        visited[x] = true;

        while(!q.isEmpty()) {
            Integer cur = q.poll();

            for(int v : map[cur]) {
                if (!visited[v]) {
                    q.add(v);
                    visited[v] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
