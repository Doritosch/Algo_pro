import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str;
        while((str = br.readLine()) != null && !str.isEmpty()) {
            st = new StringTokenizer(str);
            if(!st.hasMoreTokens()) {
                break;
            }
            String s = st.nextToken();
            String t = st.nextToken();

            int count = 0;
            for(int i=0; i<t.length(); i++) {
                if(s.charAt(count)==t.charAt(i)) {
                    count++;
                }
                if(s.length()==count) {
                    break;
                }
            }

            if(s.length()==count) {
                sb.append("Yes").append("\n");
            } else {
                sb.append("No").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}