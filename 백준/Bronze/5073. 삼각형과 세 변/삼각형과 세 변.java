import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(exit(a,b,c)) break;

            sb.append(checkTriangle(a,b,c)).append("\n");
        }

        System.out.print(sb.toString());
    }
    public static boolean exit(int a, int b, int c) {
        return ((a==0 && b==0) && c==0) ? true : false;
    }
    public static String checkTriangle(int a, int b, int c) {
        if(isValidTriangle(a,b,c)) {
            if(a==b) {
                if(b==c) {
                    return "Equilateral";
                }
                else {
                    return "Isosceles";
                }
            }
            else {
                if(b==c) {
                    return "Isosceles";
                }
                else if(c==a){
                    return "Isosceles";
                }
                else {
                    return "Scalene";
                }
            }
        }
        else {
            return "Invalid";
        }
    }
    private static boolean isValidTriangle(int a, int b, int c) {
        int[] line = {a,b,c};
        Arrays.sort(line);

        if(line[2]<line[0]+line[1]) {
            return true;
        }
        else {
            return false;
        }
    }
}