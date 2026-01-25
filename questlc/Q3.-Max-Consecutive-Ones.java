1class Solution {
2    public int findMaxConsecutiveOnes(int[] nums) {
3        int ans = 0;
4        int count = 0;
5        for(int i=0; i<nums.length; i++){
6            if(nums[i]==1){
7                count++;
8            }else{
9                count = 0;
10            }
11            ans = Math.max(ans, count);
12        }   
13        return ans;  
14    }
15}