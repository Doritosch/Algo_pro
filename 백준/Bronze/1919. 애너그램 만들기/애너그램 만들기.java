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

        String a = br.readLine();
        String b = br.readLine();
        int[] countA = new int[26];
        int[] countB = new int[26];

        int answer = 0;
        for(int i=0; i<a.length(); i++) {
            countA[a.charAt(i)-'a']++;
        }
        for(int i=0; i<b.length(); i++) {
            countB[b.charAt(i)-'a']++;
        }

        for(int j=0; j<26; j++) {
            if ( countA[j] != countB[j] ) {
                answer += Math.abs(countA[j] - countB[j]);
            }
        }

        System.out.println(answer);
    }

}