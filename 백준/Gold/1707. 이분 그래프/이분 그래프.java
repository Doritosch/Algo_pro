import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph = new ArrayList[v+1];
            visited = new int[v+1];

            for(int j=1; j<=v; j++) {
                graph[j] = new ArrayList<Integer>();
            }

            for(int j=0; j<e; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph[start].add(end);
                graph[end].add(start);
            }
            boolean isValid = true;
            for(int j=1; j<=v; j++) {
                if (visited[j] == 0) {
                    if (!bfs(j)) {
                        isValid = false;
                        break;
                    }
                }
            }
            System.out.println(isValid ? "YES" : "NO");
        }
    }
    public static boolean bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int value : graph[cur]) {
                if (visited[value] == 0) {
                    q.add(value);
                    visited[value] = -visited[cur];
                } else if (visited[cur] == visited[value]) {
                    return false;
                }
            }
        }
        return true;
    }
}
