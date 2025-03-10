class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        boolean[] checked = new boolean[schedules.length];
        
        for(int i=0; i<schedules.length; i++) {
            int today= startday;
            int hours = schedules[i] / 100;
            int minutes = schedules[i] % 100;
            minutes += 10;
            if (minutes >= 60) {
                hours++;
                minutes -= 60;
            }
            
            int goalTime = (hours*100) + minutes;
            for(int j=0; j<timelogs[i].length; j++) {
                if (today%7==0 || today%7==6) {
                    today++;
                    continue;
                }
                
                if (timelogs[i][j] > goalTime) {
                    checked[i] = true;
                    break;
                }
                
                today++;
            }
        }
        
        for(boolean check : checked) {
            if(!check) {
                answer++;
            }
        }
        
        return answer;
    }
}