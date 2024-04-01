import java.util.*;

// 단지번호붙이기
public class Main {
    static boolean[][] visited;
    static ArrayList<Integer>[] graph;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int count, n;
    static ArrayList<Integer> answer;
    public static void solution() throws Exception {
        var scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());

        visited = new boolean[n][n];
        graph = new ArrayList[n];
        answer = new ArrayList<>();
        count = 1;

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            String input = scanner.nextLine();
            String[] tokens = input.split("");
            for(String token : tokens){
                graph[i].add(Integer.parseInt(token));
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && graph[i].get(j) == 1){
                    DFS(i, j);
                    answer.add(count);
                    count = 1;
                }
            }
        }

        Collections.sort(answer);
        System.out.print(answer.size()+"\n");
        for(int i = 0; i < answer.size(); i++){
            System.out.print(answer.get(i)+"\n");
        }
    }
    public static void DFS(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx >= 0 && ny >= 0 && nx < n && ny < n && graph[nx].get(ny)==1 && !visited[nx][ny]){
                count++;
                DFS(nx, ny);
            }
        }
    }
    public static void main(String args[]) throws Exception {
        solution();
    }
}
