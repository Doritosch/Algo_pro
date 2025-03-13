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

        int num = Integer.parseInt(br.readLine());
        int[] number = new int[10]; // 0~9
        int answer = 0;

        while(num>0) {
            int n = num%10;
            num /= 10;

            number[n]++;
            if ( n==6 || n==9 ) {
                answer = Math.max(answer, (number[6]+number[9])/2 + (number[6]+number[9])%2);
            } else {
                answer = Math.max(answer, number[n]);
            }
        }

        System.out.println(answer);
    }

}