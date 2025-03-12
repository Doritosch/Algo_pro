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
        String[] result = {"E", "A", "B", "C", "D"};

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            int count = 0;
            for(int j=0; j<4; j++) {
                int state = Integer.parseInt(st.nextToken());
                if ( state == 0 ) {
                    count++;
                }
            }
            sb.append(result[count]).append("\n");
        }

        System.out.println(sb.toString());
    }
}