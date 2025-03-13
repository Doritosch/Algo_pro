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

        String s = br.readLine();
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }

        for(int i=0; i<26; i++) {
            sb.append(count[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}