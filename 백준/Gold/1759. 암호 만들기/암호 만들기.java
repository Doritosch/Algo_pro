import java.util.*;
import java.io.*;

public class Main {

    static char[] input;
    static char[] arr;
    static int n,m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n];
        input = new char[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            input[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(input);

        backTracking(0,0);
    }
    public static void backTracking(int at, int depth) {
        if ( depth==n ) {
            if ( isValidPassword() ) {
                for(int i=0; i<n; i++) {
                    System.out.print(arr[i]);
                }
                System.out.println();
            }
            return;
        }

        for(int i=at; i<m; i++) {
            char ch = input[i];
            arr[depth] = ch;
            backTracking(i+1, depth+1);
        }
    }
    public static boolean isValidPassword() {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        int vowelCount = 0;
        int consCount = 0;
        for(char element : arr) {
            boolean flag = false;
            for(char vowel : vowels) {
                if ( element == vowel ) {
                    flag = true;
                    break;
                }
            }
            if ( flag ) {
                vowelCount++;
            } else {
                consCount++;
            }
        }

        if ( vowelCount>=1 && consCount>=2 ) {
            return true;
        }
        return false;
    }
}