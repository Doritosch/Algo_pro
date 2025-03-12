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

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0; i<7; i++) {
            int n = Integer.parseInt(br.readLine());

            if ( n%2 == 1 ) {
                sum += n;

                if ( min > n ) {
                    min = n;
                }
            }
        }
        
        if ( sum == 0 ) {
            sb.append(-1);
        } else {
            sb.append(sum).append("\n").append(min);
        }
        System.out.println(sb.toString());
    }
}