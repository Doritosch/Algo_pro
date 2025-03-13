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
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] student = new int[6][2];
        int answer = 0;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            student[grade-1][gender]++;
        }

        for(int j=0; j<6; j++) {
            for(int l=0; l<2; l++) {
                if ( student[j][l]>0 ) {
                    if ( student[j][l]%k==0 ) {
                        answer += student[j][l]/k;
                    } else {
                        answer += student[j][l]/k + 1;
                    }
                }
            }
        }

        sb.append(answer);
        System.out.println(sb.toString());
    }

}