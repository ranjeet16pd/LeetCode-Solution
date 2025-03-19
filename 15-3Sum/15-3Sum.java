class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            while (j < k) {

                int sum = nums[j] + nums[k] + nums[i];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;

                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }

            }

        }
        return ans;

    }
}