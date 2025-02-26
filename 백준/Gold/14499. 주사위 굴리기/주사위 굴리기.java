import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

class Main {
    static int[] dice = {0, 0, 0, 0, 0, 0};
    static int[][] map;
    static int x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) {
            int direction = Integer.parseInt(st.nextToken());

            if(moveValid(map, x, y, direction)) {
                dice = roll(direction);
                checkMap(map, x, y);
                sb.append(dice[3]).append("\n");
            }

        }
        System.out.println(sb.toString());
    }
    //동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
    private static boolean moveValid(int[][] map, int dx, int dy, int direction) {
        int nx = dx;
        int ny = dy;
        if(direction==1) {
            nx = dx+1;
            if(check(map, nx, ny)) {
                x = nx;
                return true;
            }
        } else if(direction==2) {
            nx = dx-1;
            if(check(map, nx, ny)) {
                x = nx;
                return true;
            }
        } else if(direction==3) {
            ny = dy-1;
            if(check(map, nx, ny)) {
                y = ny;
                return true;
            }
        } else {
            ny = dy+1;
            if(check(map, nx, ny)) {
                y = ny;
                return true;
            }
        }
        return false;
    }
    private static void checkMap(int[][] map, int dx, int dy) {
        if(map[dy][dx]==0) {
            map[dy][dx] = dice[1];
        } else {
            dice[1] = map[dy][dx];
            map[dy][dx] = 0;
        };
    }
    private static boolean check(int[][] map, int dx, int dy) {
        if((dx>=0 && dy>=0)&&(map[0].length>dx&&map.length>dy)) {
            return true;
        }
        return false;
    }
    private static int[] roll(int direction) {
        // dice = {앞, 밑, 뒤, 위, 옆, 오}
        if(direction==1) {
            return new int[] {dice[0], dice[5], dice[2], dice[4], dice[1], dice[3]};
        } else if(direction==2) {
            return new int[] {dice[0], dice[4], dice[2], dice[5], dice[3], dice[1]};
        } else if(direction==3) {
            return new int[] {dice[3], dice[0], dice[1], dice[2], dice[4], dice[5]};
        } else {
            return new int[] {dice[1], dice[2], dice[3], dice[0], dice[4], dice[5]};
        }
    }
}