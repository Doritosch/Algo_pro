import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        sb.append(solve(N));
        System.out.print(sb.toString());
    }
    public static int solve(int N) {
        if(N==1) {
            return 1;
        }

        int layer = 1;
        int rage = 1;

        while(rage < N) {
            rage += 6*layer;
            layer++;
        }

        return layer;
    }
}