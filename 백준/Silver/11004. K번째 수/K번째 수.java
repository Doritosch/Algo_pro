import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSelect(A, 0, n-1, k-1);
        System.out.println(A[k-1]);
    }

    public static void quickSelect(int[] A, int left, int right, int k) {
        if (left < right) {
            int pivot = partition(A, left, right);

            if (pivot == k) return;
            else if (k < pivot) quickSelect(A, left, pivot-1, k);
            else quickSelect(A, pivot+1, right, k);
        }
    }

    public static int partition(int[] A, int left, int right) {
        int mid = (left + right) / 2;
        swap(A, left, mid); // pivot 위치를 left로
        int pivot = A[left];

        int i = left+1, j = right;
        while (i <= j) {
            while (i <= right && A[i] < pivot) i++;
            while (j >= left+1 && A[j] > pivot) j--;
            if (i <= j) swap(A, i++, j--);
        }
        swap(A, left, j);
        return j;
    }

    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}