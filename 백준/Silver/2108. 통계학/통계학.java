import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] count = new int[8001];

        int sum = 0;
        int mid = 0;
        int mode = 0;
        int range = 0;

        for(int i=0; i<N; i++) {
            int number = Integer.parseInt(br.readLine());
            sum+=number;
            numbers[i] = number;
            count[numbers[i]+4000]++;
        }

        Arrays.sort(numbers);

        int mean = (int) Math.round((double)sum/N);
        mid = numbers[N/2];
        range = numbers[N-1] - numbers[0];

        int maxFrequency = 0;
        List<Integer> modeList = new ArrayList<>();

        for(int i=0; i<count.length; i++) {
            if(count[i]>maxFrequency) {
                maxFrequency = count[i];
                modeList.clear();
                modeList.add(i-4000);
            }
            else if(count[i] == maxFrequency){
                modeList.add(i-4000);
            }
        }

        mode = (modeList.size() > 1)?modeList.get(1):modeList.get(0);

        sb.append(mean).append("\n");
        sb.append(mid).append("\n");
        sb.append(mode).append("\n");
        sb.append(range);

        System.out.print(sb.toString());
    }
}