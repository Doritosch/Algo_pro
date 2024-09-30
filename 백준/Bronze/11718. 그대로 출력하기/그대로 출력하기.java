import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;

        // EOF까지 입력받고 출력
        while((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }

        System.out.print(sb.toString());
    }
}
