class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int width = 0;
        int high = 0;
        for(int i=0; i<sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            if(w < h) {
                sizes[i][0] = h;
                sizes[i][1] = w;
            }
            
            if(width < sizes[i][0]) {
                width = sizes[i][0];
            }
            if(high < sizes[i][1]) {
                high = sizes[i][1];
            }
        }
        return width*high;
    }
}