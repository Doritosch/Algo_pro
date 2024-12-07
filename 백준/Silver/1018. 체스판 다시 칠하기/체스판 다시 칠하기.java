import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    public static int findMin(String[][] board, int s1, int s2) {
        int wCount = 0;
        int bCount = 0;
        String first = board[s1][s2];

        for(int i=s1; i<s1+8; i++) {
            for(int j=s2; j<s2+8; j++) {
                if((i+j)%2==0) {
                    if(!board[i][j].equals("W")) wCount++;
                    if(!board[i][j].equals("B")) bCount++;
                } else {
                    if(!board[i][j].equals("B")) wCount++;
                    if(!board[i][j].equals("W")) bCount++;
                }
            }
        }

        return Math.min(wCount, bCount);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        String[][] board = new String[M][N];

        for(int i=0; i<M; i++) {
            board[i] = br.readLine().split("");
        }

        int answer = M*N;
        for(int i=0; i<=M-8; i++) {
            for(int j=0; j<=N-8; j++) {
                answer = Math.min(answer, findMin(board, i, j));
            }
        }

        sb.append(answer);
        System.out.print(sb.toString());
    }
}