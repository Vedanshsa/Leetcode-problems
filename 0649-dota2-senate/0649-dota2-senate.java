import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();
            if (r < d) {
                radiant.add(r + n); // Radiant bans Dire, Radiant survives to next round
            } else {
                dire.add(d + n);    // Dire bans Radiant, Dire survives to next round
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
