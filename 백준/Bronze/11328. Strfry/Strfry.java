import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int[] count = new int[26];
            boolean flag = true;
            st = new StringTokenizer(br.readLine());

            String s1 = st.nextToken();
            String s2 = st.nextToken();

            for(int j=0; j<s1.length(); j++) {
                count[s1.charAt(j)-'a']++;
            }
            for(int l=0; l<s2.length(); l++) {
                count[s2.charAt(l)-'a']--;
            }
            for(int k=0; k<26; k++) {
                if ( count[k] != 0 ) {
                    flag = false;
                    break;
                }
            }

            if ( flag ) {
                sb.append("Possible").append("\n");
            } else {
                sb.append("Impossible").append("\n");
            }
        }

        System.out.println(sb.toString());
    }

}