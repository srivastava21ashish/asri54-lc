1class Solution {
2    public int uniquePaths(int m, int n) {
3        int[] dp = new int[n];
4
5        // first row = all 1s
6        Arrays.fill(dp, 1);
7
8        for (int i = 1; i < m; i++) {
9            for (int j = 1; j < n; j++) {
10                dp[j] = dp[j] + dp[j-1];
11            }
12        }
13
14        return dp[n-1];
15    }
16}