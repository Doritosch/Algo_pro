import java.io.*;
import java.nio.Buffer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[][] population = new int[15][15];

        for(int i=0; i<15; i++) {
            for(int j=0; j<15; j++) {
                if(i==0 || j==0) {
                    population[i][j] = j;
                } else {
                    population[i][j] = population[i-1][j] + population[i][j-1];
                }
            }

        }

        for(int i=0; i<T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(population[k][n]).append("\n");
        }

        System.out.print(sb.toString());
    }
}