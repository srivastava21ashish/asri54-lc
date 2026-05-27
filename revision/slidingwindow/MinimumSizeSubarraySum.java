package revision.slidingwindow;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l=0, r=0, sum=0, ans=Integer.MAX_VALUE;
        while(r<n){
            sum += nums[r];
            while(sum >= target){
                ans = Math.min(ans, r-l+1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }   
}