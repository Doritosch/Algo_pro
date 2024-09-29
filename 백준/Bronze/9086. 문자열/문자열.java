import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();

            sb.append(word.charAt(0)).append(word.charAt(word.length()-1));
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
