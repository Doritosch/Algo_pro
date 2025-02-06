import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sb.append(solve(arr));
        System.out.print(sb.toString());
    }
    private static String solve(int[] arr) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int num = 1;

        for(int i=0; i<arr.length; i++) {
            if(stack.empty()) {
                stack.push(num++);
                sb.append("+").append("\n");
            }
            while(stack.peek()!=arr[i]) {
                if(stack.peek() < arr[i]) {
                    stack.push(num++);
                    sb.append("+").append("\n");
                }
                else if(stack.peek() > arr[i]) {
                    return "NO";
                }
            }
            stack.pop();
            sb.append("-").append("\n");
            }

        return sb.toString();
    }
}