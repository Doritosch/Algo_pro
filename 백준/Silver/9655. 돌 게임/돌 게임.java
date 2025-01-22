import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        if(N%2==1) {
            sb.append("SK");
        } else {
            sb.append("CY");
        }

        System.out.print(sb.toString());
    }
}