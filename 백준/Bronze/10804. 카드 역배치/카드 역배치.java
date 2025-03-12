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

        int[] card = new int[21];
        for(int i=1; i<=20; i++) {
            card[i] = i;
        }

        for(int i=0; i<10; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int j=a; j<=(a+b)/2; j++) {
                int value = card[j];
                card[j] = card[b+a-j];
                card[b+a-j] = value;
            }
        }

        for(int i=1; i<=20; i++) {
            sb.append(card[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}