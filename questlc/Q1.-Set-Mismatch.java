1class Solution {
2    public int[] findErrorNums(int[] nums) {
3        int[] ans = new int[2];
4        int l = nums.length;
5        int i=0;
6        while(i<l){
7            int n = nums[i];
8            //check if not negative
9            if(n>0){
10                //check if already in correct position
11                if(n==i+1){
12                    nums[i]*=-1; // mark negative.
13                    i++;
14                }else{
15                    //if not in correct position.
16                    int t = nums[n-1];
17                    //if t is already negative means this number is faulty
18                    if(t<0){
19                        i++;
20                    }else{
21                        //move number to correct position
22                        nums[i]=nums[n-1];
23                        nums[n-1] = -n;
24                    }
25                }
26            }else{
27                //negative means already in correct position.
28                i++;
29            }
30        }
31        for(i=0; i<l; i++){
32            if(nums[i] > 0){
33                return new int[]{nums[i], i+1};
34            }
35        }
36        return ans;
37    }
38}