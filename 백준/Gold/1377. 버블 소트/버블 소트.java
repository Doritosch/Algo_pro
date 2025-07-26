import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        mData[] A = new mData[n];

        for (int i = 0; i < n; i++) {
            A[i] = new mData(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(A);

        int max = 0;
        for (int i = 0; i < n; i++) {
            int moved = A[i].index - i;
            if (moved > max) max = moved;
        }

        System.out.println(max + 1);
    }

    static class mData implements Comparable<mData> {
        int v;
        int index;

        public mData(int v, int index) {
            this.v = v;
            this.index = index;
        }

        @Override
        public int compareTo(mData o) {
            return this.v - o.v;
        }
    }
}