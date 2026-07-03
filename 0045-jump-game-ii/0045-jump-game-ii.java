class Solution {
    public int jump(int[] nums) {
        int s = 0;
        int e = 0;
        int f = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            f = Math.max(f, i + nums[i]);
            if (i == e) {
                s++;
                e = f;
            }
        }

        return s;
    }
}
