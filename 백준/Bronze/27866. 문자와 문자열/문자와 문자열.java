import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        String S = st.nextToken();

        st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());

        System.out.print(S.charAt(i-1));
    }
}
