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
        int[] answer = new int[N];
        boolean[] visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 1;
        for(int i=0; i<N; i++) {
            int num = arr[i];
            for(int j=0; j<N; j++) {
                if(!visited[j]) {
                    if(num==0) {
                        answer[j] = count++;
                        visited[j] = true;
                        break;
                    } else {
                        num--;
                    }
                }
            }
        }

        for(int i=0; i<N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.print(sb.toString());
    }
}