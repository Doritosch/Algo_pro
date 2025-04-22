import java.util.*;
import java.io.*;

public class Main {

    static int[][] gear;
    static int[] direction;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;

        gear = new int[4][8];

        for(int i=0; i<4; i++) {
            String[] inputCog= br.readLine().split("");
            for(int j=0; j<8; j++) {
                gear[i][j] = Integer.parseInt(inputCog[j]);
            }
        }

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            direction = new int[4];

            String[] pos = br.readLine().split(" ");
            int moveCog = Integer.parseInt(pos[0]);
            int dir = Integer.parseInt(pos[1]);

            direction[moveCog-1] = dir;

            checkCogwheel(moveCog-1);
            runCogwheel();
        }

        for(int i=0; i<4; i++) {
            if ( gear[i][0] == 1 ) {
                result += Math.pow(2, i);
            }
        }

        System.out.println(result);
    }
    public static void checkCogwheel(int cog) {
        for(int i=cog-1; i>=0; i--) {
            if ( gear[i][2]!=gear[i+1][6] ) {
                direction[i] = -direction[i+1];
            } else {
                break;
            }
        }

        for(int i=cog+1; i<4; i++) {
            if ( gear[i][6]!=gear[i-1][2] ) {
                direction[i] = -direction[i-1];
            } else {
                break;
            }
        }
    }
    public static void runCogwheel() {
        for(int i=0; i<4; i++) {
            if ( direction[i] == -1 ) {
                int temp = gear[i][0];
                for(int j=0; j<7; j++) {
                    gear[i][j] = gear[i][j+1];
                }
                gear[i][7] = temp;
            }

            if ( direction[i] == 1 ) {
                int temp = gear[i][7];
                for(int j=7; j>0; j--) {
                    gear[i][j] = gear[i][j-1];
                }
                gear[i][0] = temp;
            }
        }
    }
}