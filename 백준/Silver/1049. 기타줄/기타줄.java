import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int packMin = 1001;
        int eachMin = 1001;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int each = Integer.parseInt(st.nextToken());

            packMin = Math.min(pack, packMin);
            eachMin = Math.min(each, eachMin);
        }

        int answer = Math.min(Math.min((N/6)*packMin+(N%6)*eachMin, (N/6 + 1)*packMin), N*eachMin);
        sb.append(answer);
        System.out.print(sb.toString());
    }
}