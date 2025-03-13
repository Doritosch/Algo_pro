import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++) {
            list.add(i+1);
        }

        int removeNum = 0;
        sb.append("<");
        while(list.size()>1) {
            removeNum = (removeNum + k - 1) % list.size();

            sb.append(list.get(removeNum)).append(", ");

            list.remove(removeNum);
        }

        sb.append(list.get(0)).append(">");
        System.out.println(sb.toString());
    }

}