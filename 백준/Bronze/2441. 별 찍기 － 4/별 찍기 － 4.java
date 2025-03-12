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

        for(int i=n; i>0; i--) {
            for(int k=0; k<n-i; k++) {
                sb.append(" ");
            }
            for(int j=0; j<i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}