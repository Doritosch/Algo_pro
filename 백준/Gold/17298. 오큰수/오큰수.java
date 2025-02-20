import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++) {
            while(!stack.empty() && arr[stack.peek()] < arr[i]) {
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        for(int i=0; i<n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}