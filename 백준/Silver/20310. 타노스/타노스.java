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

        int[] count = new int[2];
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='0') {
                count[0]++;
            } else {
                count[1]++;
            }
        }

        count[0]/=2;
        count[1]/=2;
        String answer = "";
        for(int i=0; i<count[0]; i++) {
            sb.append(0);
        }
        for(int i=0; i<count[1]; i++) {
            sb.append(1);
        }

        System.out.print(sb.toString());
    }
}