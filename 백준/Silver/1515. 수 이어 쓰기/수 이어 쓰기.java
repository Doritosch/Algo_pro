import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int pt = 0;
        int base = 0;
        while(base++ <= 30000) {
            String tmp = String.valueOf(base);
            for(int i=0; i<tmp.length(); i++) {
                if(tmp.charAt(i)==s.charAt(pt)) {
                    pt++;
                }
                if(pt==s.length()) {
                    sb.append(base);
                    System.out.print(sb.toString());
                    return;
                }
            }
        }
    }
}