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

        for(int i=0; i<2*n-1; i++) {
            if ( i<n ) {
                for(int j=0; j<=i; j++) {
                    sb.append("*");
                }
                for(int k=0; k<(n-i-1)*2; k++) {
                    sb.append(" ");
                }
                for(int l=0; l<=i; l++) {
                    sb.append("*");
                }
            } else {
                for(int j=0; j<2*n-i-1; j++) {
                    sb.append("*");
                }
                for(int k=0; k<(i-n+1)*2; k++) {
                    sb.append(" ");
                }
                for(int l=0; l<2*n-i-1; l++) {
                    sb.append("*");
                }
            }

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}