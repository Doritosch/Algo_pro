import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int[] nums = new int[3];
        for(int i=0; i<nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if ( nums[i] > nums[j] ) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        
        for(int i=0; i<nums.length; i++) {
            sb.append(nums[i]).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}