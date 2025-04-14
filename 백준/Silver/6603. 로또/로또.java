import java.util.*;
import java.io.*;

public class Main {

    static int[] input;
    static int[] arr;
    static int k;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());

            if ( k==0 ) {
                break;
            }

            arr = new int[k];
            input = new int[k];
            for(int i=0; i<k; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            backTracking(0, 0);

            System.out.println();
        }
    }
    public static void backTracking(int at, int depth) {
        if ( depth==6 ) {
            for(int i=0; i<depth; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        for(int i=at; i<k; i++) {
            arr[depth] = input[i];
            backTracking(i+1, depth+1);
        }
    }
}