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

        int n = Integer.parseInt(br.readLine());

        int[] callTime = new int[n];

        int Young = 0;
        int Min = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            callTime[i] = Integer.parseInt(st.nextToken());

            Young += (callTime[i] / 30) * 10 + 10;
            Min += (callTime[i] / 60) * 15 + 15;
        }

        if ( Young > Min ) {
            sb.append("M ").append(Min);
        } else if ( Young == Min ) {
            sb.append("Y M ").append(Young);
        } else {
            sb.append("Y ").append(Young);
        }

        System.out.println(sb.toString());
    }
}