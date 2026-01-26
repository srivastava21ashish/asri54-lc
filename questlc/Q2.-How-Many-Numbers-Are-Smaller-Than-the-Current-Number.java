1class Solution {
2    public int[] smallerNumbersThanCurrent(int[] nums) {
3        int[] countArr = new int[nums.length];
4        int[] freqArr = new int[101];
5
6        for (int i=0;i<nums.length;i++)
7            freqArr[nums[i]]++;
8        
9        for (int i=1;i<101;i++)
10        {
11            freqArr[i]+=freqArr[i-1];
12        }
13        for (int i=0;i<nums.length;i++)
14        {
15            countArr[i] = (nums[i]==0)?0:freqArr[nums[i] - 1];
16        }
17        return countArr;
18    }
19}