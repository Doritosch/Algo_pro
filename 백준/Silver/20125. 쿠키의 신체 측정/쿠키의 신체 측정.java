import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String[][] board = new String[N][N];

        for(int i=0; i<N; i++) {
            String[] line = br.readLine().split("");
            for(int j=0; j<N; j++) {
                board[i][j] = line[j];
            }
        }

        Point heart = findHeart(board);
        sb.append(heart.x+1).append(" ").append(heart.y+1).append("\n");

        int[] bodySize = calBodySize(board, heart);
        for(int i=0; i<5; i++) {
            sb.append(bodySize[i]).append(" ");
        }

        System.out.print(sb.toString());
    }
    private static Point findHeart(String[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j].equals("*")) {
                    return new Point(i+1,j);
                }
            }
        }
        return new Point(-1,-1);
    }
    private static int[] calBodySize(String[][] board, Point heart) {
        int[] bodySize = new int[5];

        int leftArm = heart.y-1;
        int rightArm = heart.y+1;
        int waist = heart.x+1;
        while(leftArm>=0 && board[heart.x][leftArm].equals("*")) {
            bodySize[0] += 1;
            leftArm--;
        }
        while(rightArm<board[heart.x].length && board[heart.x][rightArm].equals("*")) {
            bodySize[1] += 1;
            rightArm++;
        }
        while(board[waist][heart.y].equals("*")) {
            bodySize[2] += 1;
            waist++;
        }
        Point leftLeg = new Point(waist, heart.y-1);
        Point rightLeg = new Point(waist, heart.y+1);
        while(leftLeg.x<board.length && board[leftLeg.x][leftLeg.y].equals("*")) {
            bodySize[3] += 1;
            leftLeg.x++;
        }
        while(rightLeg.x<board.length && board[rightLeg.x][rightLeg.y].equals("*")) {
            bodySize[4] += 1;
            rightLeg.x++;
        }
        return bodySize;
    }
}