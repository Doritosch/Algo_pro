import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Heap heap = new Heap();

        for (int i=0; i<n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value==0) {
                if (heap.heap.size() <= 1){
                    sb.append(0).append("\n");
                } else {
                    sb.append(heap.delete()).append("\n");
                }
            } else {
                heap.insert(value);
            }
        }
        System.out.print(sb.toString());
    }
}

class Heap {
    List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
        heap.add(0);
    }

    public void insert(int value) {
        heap.add(value);

        int cur = heap.size()-1;
        int par = cur/2;

        while (true) {
            if(par == 0 || heap.get(cur)>=heap.get(par)) {
                break;
            }

            int temp = heap.get(cur);
            heap.set(cur, heap.get(par));
            heap.set(par, temp);

            cur = par;
            par = cur / 2;
        }
    }

    public int delete() {
        int top = heap.get(1);

        heap.set(1, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int cur = 1;
        while (true) {
            int left = cur*2;
            int right = cur*2+1;

            if (left >= heap.size()) {
                break;
            }

            int minValue = heap.get(left);
            int min = left;
            if (right < heap.size() && minValue > heap.get(right)) {
                minValue = heap.get(right);
                min = right;
            }

            if (minValue < heap.get(cur)) {
                int temp = heap.get(cur);
                heap.set(cur, minValue);
                heap.set(min, temp);
                cur = min;
            } else {
                break;
            }
        }
        return top;
    }
}