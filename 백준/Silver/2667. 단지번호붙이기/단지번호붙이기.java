import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] matrix;
    static int area;
    static int count;
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        List<Integer> answer = new ArrayList<>();

        count = 0;

        st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        matrix = new int[v+1][v+1];
        visited = new boolean[v+1][v+1];

        for(int i=0; i<v; i++){
            String line = br.readLine();
            for(int j=0; j<v; j++){
                matrix[i+1][j+1] = Character.getNumericValue(line.charAt(j));
            }
        }

        for(int i=1; i<v+1; i++){
            for(int j=1; j<v+1; j++){
                if(!visited[i][j] && matrix[i][j]==1 ){
                    count++;
                    area = 0;
                    dfs(i,j);
                    answer.add(area);
                }
            }
        }
        answer.sort(Comparator.naturalOrder());
        sb.append(count).append("\n");
        for(int size : answer){
            sb.append(size).append("\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;
        area++;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if((nx>0 && ny>0) && (nx<matrix.length && ny<matrix[0].length)){
                if(!visited[nx][ny] && matrix[nx][ny] == 1){
                    dfs(nx,ny);
                }
            }
        }
    }


    public static void main(String args[]) throws Exception {
        solution();
    }
}