// Last updated: 08/08/2025, 19:23:01
import java.util.*;

class Solution {
    public int racecar(int target) {
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        q.offer(new int[]{0, 1});
        visited.add("0,1");
        int steps = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] state = q.poll();
                int pos = state[0], speed = state[1];
                
                if (pos == target) return steps;
                
                int newPos = pos + speed;
                int newSpeed = speed * 2;
                String forwardKey = newPos + "," + newSpeed;
                if (Math.abs(newPos) <= 2 * target && visited.add(forwardKey)) {
                    q.offer(new int[]{newPos, newSpeed});
                }
                
                int revSpeed = speed > 0 ? -1 : 1;
                String reverseKey = pos + "," + revSpeed;
                if (visited.add(reverseKey)) {
                    q.offer(new int[]{pos, revSpeed});
                }
            }
            steps++;
        }
        
        return -1;
    }
}
