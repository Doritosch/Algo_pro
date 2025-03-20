import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++) {
            for(int j=0; j<n-i; j++) {
                sb.append(" ");
            }
            for(int k=0; k<2*i-1; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i=n-1; i>0; i--) {
            for(int j=0; j<n-i; j++) {
                sb.append(" ");
            }
            for(int k=0; k<2*i-1; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}