import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] board;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        board = new int[N];

        solve(0);

        sb.append(result);
        System.out.print(sb.toString());
    }

    public static void solve(int row) {
        if(row == N) {
            result++;
            return;
        }

        for(int i=0; i<N; i++) {
            if(isValid(row, i)) {
                board[row] = i;
                solve(row+1);
            }
        }
    }

    private static boolean isValid(int row, int i) {
        for(int j=0; j<row; j++) {
            if(board[j] == i || Math.abs(board[j]-i) == Math.abs(j-row)) {
                return false;
            }
        }
        return true;
    }
}