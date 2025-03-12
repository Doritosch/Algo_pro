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

        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<2*n; i++) {
            if ( i<=n ) {
                for(int j=0; j<i-1; j++) {
                    sb.append(" ");
                }
                for(int k=0; k<(2*(n-i+1))-1; k++) {
                    sb.append("*");
                }
            } else {
                for(int j=0; j<2*n-i-1; j++) {
                    sb.append(" ");
                }
                for(int k=0; k<(i-n+1)*2-1; k++) {
                    sb.append("*");
                }
            }

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}