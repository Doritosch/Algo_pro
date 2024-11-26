import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] coins = {25, 10, 5, 1};

        for(int i=0; i<n; i++) {
            int change = Integer.parseInt(br.readLine());

            for(int coin:coins) {
                sb.append(change/coin).append(" ");
                change %= coin;
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}