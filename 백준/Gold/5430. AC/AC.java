import java.util.*;
import java.io.*;

public class Main {
    static String[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());


        for(int i=0; i<t; i++) {
            String[] pos = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            if ( !input.isEmpty() ) {
                arr = input.substring(1, input.length()-1).split(",");
            } else {
                arr = new String[0];
            }

            AC(pos);
        }
        System.out.println(sb.toString());
    }
    public static void AC(String[] pos) {
        LinkedList<Integer> deque = new LinkedList<>();

        for(int j=0; j< arr.length; j++) {
            if ( !arr[j].isEmpty() ) {
                deque.offer(Integer.parseInt(arr[j]));
            }
        }

        boolean flag = false;
        for(String command : pos) {
            if ( command.equals("R") ) {
                flag = !flag;
            } else {
                if ( deque.isEmpty() ) {
                    sb.append("error").append("\n");
                    return;
                }

                if ( flag ) {
                    deque.pollLast();
                } else {
                    deque.pollFirst();
                }
            }
        }
        printDeque(deque, flag);
    }

    public static void printDeque(LinkedList<Integer> deque, boolean flag) {

        sb.append("[");

        if ( deque.size() > 0 ) {
            if ( flag ) {
                sb.append(deque.pollLast());

                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            } else {
                sb.append(deque.pollFirst());

                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
        }
        sb.append("]").append("\n");
    }
}