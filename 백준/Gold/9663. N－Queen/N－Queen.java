import java.util.*;
import java.io.*;

public class Main {

    static int[] board;
    static int n;
    static int count=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n];

        backTracking(0);

        System.out.println(count);
    }
    public static void backTracking(int depth) {
        if ( depth == n ) {
            count++;
            return;
        }

        for(int i=0; i<n; i++) {
            board[depth] = i;
            if ( isValidSquare(depth) ) {
                backTracking(depth+1);
            }
        }
    }
    // 열 확인
    public static boolean isValidSquare(int square) {
        for(int i=0; i<square; i++) {
            if ( board[i] == board[square] || square-i == Math.abs(board[square]-board[i])) {
                return false;
            }
        }
        return true;
    }
}