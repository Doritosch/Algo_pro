class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] start = findStart(park);
        Node loc = new Node(start[0], start[1]);
        
        for(String route : routes) {
            String[] dir = route.split(" ");
            loc = validateDirection(park, loc, dir[0], Integer.valueOf(dir[1]));    
        }
        return loc.toIntArray();
    }
    public int[] findStart(String[] park) {
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[0].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }
    public Node validateDirection(String[] park, Node n, String d, int l) {
        Node cur = new Node(n.x, n.y);
        
        for(int i=0; i<l; i++) {
            if (d.equals("E")) {
                cur.y += 1;
            }
            if (d.equals("W")) {
                cur.y -= 1;
            }
            if (d.equals("S")) {
                cur.x += 1;
            }
            if (d.equals("N")) {
                cur.x -= 1;
            }
            if ((cur.x<0 || cur.y<0) || (cur.x>=park.length || cur.y>=park[0].length())) {
                return n;
            }
            if (park[cur.x].charAt(cur.y) == 'X') {
                return n;
            }
        }
        return cur;
    }
    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int[] toIntArray() {
            return new int[]{x, y};
        }
    }
}