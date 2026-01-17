import java.util.*;
import java.io.*;


public class Main {
    private static StringBuffer sb;
    private static int cursor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuffer(br.readLine());
        cursor = sb.length();

        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++) {
            st = new StringTokenizer(br.readLine());
            String token = st.nextToken();
            if (token.equals("L")) {
                pressL();
            } else if (token.equals("D")) {
                pressR();
            } else if (token.equals("B")) {
                pressB();
            } else {
                char c = st.nextToken().charAt(0);
                pressP(c);
            }
        }

        System.out.println(String.valueOf(sb));
    }

    public static void pressL() {
        if (cursor <= 0) {
            return;
        }
        cursor -= 1;
    }
    public static void pressR() {
        if (cursor >= sb.length()) {
            return;
        }
        cursor += 1;
    }
    public static void pressB() {
        if (cursor <= 0) {
            return;
        }
        sb.deleteCharAt(cursor-1);
        cursor--;
    }
    public static void pressP(char c) {
        sb.insert(cursor++, c);
    }
}
