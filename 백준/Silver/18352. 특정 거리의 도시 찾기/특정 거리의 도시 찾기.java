import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static List<Integer>[] A;
    static int[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        List<Integer> answer = new ArrayList<>();
        A = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            A[i] = new ArrayList<Integer>();
        }
        visited = new int[n+1];
        Arrays.fill(visited, -1);

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
        }

        bfs(x);
        for(int i=1; i<=n; i++) {
            if (visited[i] == k) {
                answer.add(i);
            }
        }
        Collections.sort(answer);
        
        if (answer.size() == 0) {
            System.out.println(-1);
        } else {
            for(int a : answer) {
                System.out.println(a);
            }
        }
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start]++;
        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i : A[cur]) {
                if (visited[i] == -1) {
                    visited[i] = visited[cur] + 1;
                    q.add(i);
                }
            }
        }
    }
}