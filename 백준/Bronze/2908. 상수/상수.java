import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int A = Integer.parseInt(new StringBuilder(a).reverse().toString());
        int B = Integer.parseInt(new StringBuilder(b).reverse().toString());

        if(A>B) {
            sb.append(A);
        }
        else {
            sb.append(B);
        }

        System.out.print(sb.toString());
    }
}
