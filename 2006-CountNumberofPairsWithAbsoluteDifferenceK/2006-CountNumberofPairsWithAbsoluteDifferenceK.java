// Last updated: 17/05/2025, 14:22:07
class Solution {
    public int countKDifference(int[] nums, int k) {

        // brute force

        int ans=0;

        int n=nums.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(Math.abs(nums[i]-nums[j])==k) ans+=1;
            }
        }
        return ans;
        
    }
}