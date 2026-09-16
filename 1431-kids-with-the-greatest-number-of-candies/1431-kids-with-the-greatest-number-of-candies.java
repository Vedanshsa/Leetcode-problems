import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandies = 0;
        for (int c : candies) {
            maxCandies = Math.max(maxCandies, c);
        }
        for (int c : candies) {
            result.add(c + extraCandies >= maxCandies);
        }
        return result;
    }
}
