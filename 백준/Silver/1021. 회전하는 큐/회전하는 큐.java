import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1. pop
        // 2. pop_left -> push_right
        // 3. pop_right -> push_left
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        int answer = 0;

        for(int i=1; i<=n; i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int num = Integer.parseInt(st.nextToken());

            int index = deque.indexOf(num);
            int halfIndex = deque.size()/2;

            if ( halfIndex < index ) {
                while(deque.getFirst() != num) {
                    int pollNum = deque.removeLast();
                    deque.offerFirst(pollNum);
                    answer++;
                }
            } else {
                while(deque.getFirst() != num) {
                    int pollNum = deque.removeFirst();
                    deque.offerLast(pollNum);
                    answer++;
                }
            }
            deque.pollFirst();
        }

        System.out.println(answer);

    }
}