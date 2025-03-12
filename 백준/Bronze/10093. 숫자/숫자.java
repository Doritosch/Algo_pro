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

        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long a = Math.min(n, m);
        long b = Math.max(n, m);

        if ( a==b ) {
            sb.append(b-a).append("\n");
        } else {
            sb.append(b-a-1).append("\n");
        }
        for(long i=a+1; i<b; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}