// Last updated: 17/05/2025, 14:41:31
class Solution {
    public int countKDifference(int[] nums, int k) {

        Map<Integer, Integer> mp = new HashMap<>();

        for (Integer ele : nums) {
            mp.put(ele+k, mp.getOrDefault(ele+k, 0) + 1);
        }

        int ans = 0;
        for (Integer ele : nums) {
            if (mp.containsKey(ele)) {
                ans += mp.get(ele);
            }
        }
        return ans;

    }
}