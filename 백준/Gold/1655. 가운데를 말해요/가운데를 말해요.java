import java.io.*;
import java.util.*;

class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());

            if ( maxHeap.size() == minHeap.size() ) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            if ( !maxHeap.isEmpty() && !minHeap.isEmpty() ) {
                if ( maxHeap.peek() > minHeap.peek() ) {
                    int temp = maxHeap.poll();
                    maxHeap.add(minHeap.poll());
                    minHeap.add(temp);
                }
            }
            System.out.println(maxHeap.peek());
        }
    }
}