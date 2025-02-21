import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String line;
        while((line = br.readLine()) != null && !line.isEmpty()) {
            st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) {
                break;
            }
            String s = st.nextToken();
            String t = st.nextToken();

            int count = 0;
            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(count) == t.charAt(i)) {
                    count++;
                }
                if (s.length() == count) {
                    break;
                }
            }

            if (s.length() == count) {
                sb.append("Yes").append("\n");
            } else {
                sb.append("No").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}