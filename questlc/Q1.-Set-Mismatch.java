1class Solution {
2    public int[] findErrorNums(int[] nums) {
3        int duplicate = -1, missing = -1;
4
5        // Mark visited numbers
6        for (int i = 0; i < nums.length; i++) {
7            int idx = Math.abs(nums[i]) - 1;
8
9            if (nums[idx] < 0) {
10                duplicate = idx + 1;
11            } else {
12                nums[idx] = -nums[idx];
13            }
14        }
15
16        // Find missing number
17        for (int i = 0; i < nums.length; i++) {
18            if (nums[i] > 0) {
19                missing = i + 1;
20                break;
21            }
22        }
23
24        return new int[]{duplicate, missing};
25    }
26}
27