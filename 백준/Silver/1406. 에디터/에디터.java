import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String s = br.readLine();
        sb.append(s);
        int n = Integer.parseInt(br.readLine());

        int length = s.length();
        int cursor = s.length();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if ( command.equals("L") ) {
                if ( cursor>0 ) {
                    cursor--;
                }
            } else if ( command.equals("D") ) {
                if ( cursor<length ) {
                    cursor++;
                }
            } else if ( command.equals("B") ) {
                if ( cursor>0 ) {
                    sb.delete(cursor-1, cursor);
                    cursor--;
                    length--;
                }
            } else {
                String c = st.nextToken();
                sb.insert(cursor, c);
                cursor++;
                length++;
            }
        }

        System.out.println(sb.toString());
    }
}