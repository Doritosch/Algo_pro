import java.io.*;
import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = new char[s.length()];
        
        for(int i=0; i<arr.length; i++) {
            arr[i] = s.charAt(i);
        }
        
        Arrays.sort(arr);
        for(int i=arr.length-1; i>=0; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}