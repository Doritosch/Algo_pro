import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] switches = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int T = Integer.parseInt(br.readLine());
        int[][] students = new int[T][2];
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            students[i][0] = Integer.parseInt(st.nextToken());
            students[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] answer = solve(switches, students);
        for(int i=1; i<=N; i++) {
                sb.append(answer[i]).append(" ");
                if(i%20==0) {
                    sb.append("\n");
                }
        }
        System.out.print(sb.toString());
    }
    private static int[] solve(int[] switches, int[][]students) {
        int[] copySwitches = switches;

        for(int i=0; i<students.length; i++) {
            // 남자 학생일때 자기 번호 배수
            if(students[i][0] == 1) {
                int value = students[i][1];
                for(int j=value; j<copySwitches.length; j+=value) {
                    if(copySwitches[j]==1) {
                        copySwitches[j] = 0;
                    } else {
                        copySwitches[j] = 1;
                    }
                }
            } // 여자 학생일때 중심에서 부터
            else {
                int value = students[i][1];
                for(int j=0; j<switches.length/2; j++) {
                    if(j==0) {
                        if(copySwitches[value] == 1) {
                            copySwitches[value] = 0;
                        } else {
                            copySwitches[value] = 1;
                        }
                    } else {
                        if(((value-j)>0 && (value+j<switches.length)) && switches[value-j] == switches[value+j]) {
                            if(copySwitches[value-j] == 1) {
                                copySwitches[value-j] = copySwitches[value+j] = 0;
                            } else {
                                copySwitches[value-j] = copySwitches[value+j] = 1;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return copySwitches;
    }
}