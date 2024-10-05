import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] line = br.readLine().split(" ");
        int[] chess = new int[line.length];
        int[] standard = {1, 1, 2, 2, 2, 8};
        
        for(int i=0; i<line.length; i++) {
            int value = Integer.parseInt(line[i]);
            sb.append(standard[i]-value).append(" ");
        }

        System.out.print(sb.toString());
    }
}
