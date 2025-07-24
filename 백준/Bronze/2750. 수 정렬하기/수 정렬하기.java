import java.io.*;
import java.util.*;

/**
 * 2750 수 정렬하기
 *
 * n(수의 개수)
 * A(배열 선언)
 * for(i : 0~n-1) {
 *     for(j : 0~n-i-1) {
 *         현재 배열의 값보다 오른쪽 값이 더 작으면 swap
 *     }
 * }
 */
class Main
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        for(int i=0; i<n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                if ( A[j] > A[j+1] ) {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }

        for(int i=0; i<n; i++) {
            System.out.println(A[i]);
        }
    }
}