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

        for(int i=n-1; i>=0; i--) {
            for(int k=0; k<n-i-1; k++) {
                sb.append(" ");
            }
            for(int j=0; j<(i*2)+1; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}