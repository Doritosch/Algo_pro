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

        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] dict = new String[n];

        for(int i=0; i<n; i++) {
            dict[i] = br.readLine();
        }

        for(int i=0; i<26; i++) {
            String[] rotate = new String[s.length()];
            String rotatedStr = rotate(s, i);
            boolean flag = check(rotatedStr, dict);

            if(flag) {
                sb.append(rotatedStr);
                break;
            }
        }
        System.out.println(sb.toString());
    }
    public static String rotate(String s, int i) {
        StringBuilder sb = new StringBuilder();

        for(int j=0; j<s.length(); j++) {
            char c = s.charAt(j);
            sb.append(((char)('a' + (c - 'a' - i + 26) % 26)));
        }
        return sb.toString();
    }
    private static boolean check(String rotate, String[] s) {
        for(int i=0; i<s.length; i++) {
            int index = rotate.indexOf(s[i]);

            if(index!=-1) {
                return true;
            }
        }
        return false;
    }
}