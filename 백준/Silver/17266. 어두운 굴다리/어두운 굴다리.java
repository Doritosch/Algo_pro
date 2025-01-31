import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] spot = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            spot[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(binarySearch(spot, N));
        System.out.print(sb.toString());
    }
    private static int binarySearch(int[] spot, int N) {
        int left= 1;
        int right = N;

        int result = N;
        while(left<=right) {
            int mid = (left+right)/2;

            if(canLightUp(spot, N, mid)) {
                result = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return result;
    }

    private static boolean canLightUp(int[] spots, int N, int mid) {
        int point = 0;

        for(int spot: spots) {
            if(spot-mid>point) {
                return false;
            }
            point = spot+mid;
        }

        return point >= N;
    }
}