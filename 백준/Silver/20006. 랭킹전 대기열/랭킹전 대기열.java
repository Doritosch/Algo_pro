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

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Player>> teams = new ArrayList<>();

        boolean added = false;
        for(int i=0; i<p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            Player player = new Player(level, name);
            added = false;
            for(List<Player> team: teams) {
                if(team.size()<m) {
                    if(team.get(0).level-10<=player.level&&team.get(0).level+10>=player.level) {
                        team.add(player);
                        added = true;
                        break;
                    }
                }
            }

            if(!added) {
                List<Player> newTeam = new ArrayList<>();
                newTeam.add(player);
                teams.add(newTeam);
            }
        }

        for(List<Player> team:teams) {
            team.sort(Comparator.comparing(pl -> pl.name));
            if(team.size()==m) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }

            for(Player player: team) {
                sb.append(player.level).append(" ").append(player.name).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
    static class Player {
        int level;
        String name;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }
}