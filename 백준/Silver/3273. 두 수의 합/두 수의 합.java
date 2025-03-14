import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int i=0;
        int j=arr.length-1;
        while(i<j) {
            if ( arr[i] + arr[j] < k ) {
                i++;
            } else if ( arr[i] + arr[j] > k ) {
                j--;
            } else {
                answer++;
                i++;
            }
        }

        System.out.println(answer);
    }

}