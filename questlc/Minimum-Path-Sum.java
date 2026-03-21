1class Solution {
2    int[][] dp = null;
3    public int minPathSum(int[][] grid) {
4        int n = grid.length;
5        int m = grid[0].length;
6        dp = new int[n][m];
7        dp[n-1][m-1] = grid[n-1][m-1];
8        for(int i=n-2; i>=0; i--){
9            dp[i][m-1] = grid[i][m-1]+dp[i+1][m-1];
10        }
11
12        for(int j=m-2; j>=0; j--){
13            dp[n-1][j] = grid[n-1][j]+dp[n-1][j+1];
14        }
15
16        for(int i=n-2; i>=0; i--){
17            for(int j=m-2; j>=0; j--){
18                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
19            }
20        }
21        return dp[0][0];
22    }
23}