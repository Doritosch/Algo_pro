import java.util.*;
import java.io.*;

/**
 * 1167 트리의 지름
 *
 * n(정점의 개수), adj(정점간 거리를 저장하는 인접 리스트), visited(방문 유무), distance(거리 측정)
 * maxDist(최장 거리), farNode(최장 거리인 정점)
 * for(n까지 반복) {
 *     adj 초기화 및 edge 저장
 * }
 * visited, distance 초기화
 * dfs(1)
 * 
 * dfs(farNode)
 * visted, distance 초기화
 * dfs(u <- index) {
 *     if (dist[u] > maxDist) maxDist 갱신, farNode 갱신
 *     for(1~n까지 반복) {
 *         if (!visited[i]) distance[u] 갱신 및 dfs(u)
 *     }
 * }
 */
public class Main {
    static int n;
    static List<Edge>[] adj;
    static boolean[] visited;
    static int[] dist;
    static int farNode;
    static int maxDist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) break;
                int w = Integer.parseInt(st.nextToken());
                adj[u].add(new Edge(v, w));
                adj[v].add(new Edge(u, w));
            }
        }

        visited = new boolean[n + 1];
        dist = new int[n + 1];
        maxDist = 0; farNode = 1;
        dfs(1);

        visited = new boolean[n + 1];
        dist = new int[n + 1];
        maxDist = 0;
        dfs(farNode);

        System.out.println(maxDist);
    }

    static void dfs(int u) {
        visited[u] = true;
        if (dist[u] > maxDist) {
            maxDist = dist[u];
            farNode = u;
        }

        for(Edge e : adj[u]) {
            if (!visited[e.to]) {
                dist[e.to] = dist[u] + e.w;
                dfs(e.to);
            }
        }
    }

    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }
}
