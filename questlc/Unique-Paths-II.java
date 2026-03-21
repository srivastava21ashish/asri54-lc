1class Solution {
2    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
3        int n = obstacleGrid.length;
4        int m = obstacleGrid[0].length;
5        int[][] dp = new int[n][m];
6        if(obstacleGrid[0][0] == 1){
7            return 0; //no paths can be formed.
8        }
9        dp[0][0] = 1;
10        for(int i=0; i<n; i++){
11            if(obstacleGrid[i][0] == 0){
12                dp[i][0] = 1;
13            }else{
14                break;
15            }
16        }
17
18        for(int j=0; j<m; j++){
19            if(obstacleGrid[0][j] == 0){
20                dp[0][j] = 1;
21            }else{
22                break;
23            }
24        }
25
26        for(int i=1; i<n; i++){
27            for(int j=1; j<m; j++){
28                if(obstacleGrid[i][j] == 1){
29                    dp[i][j] = 0;
30                }else{
31                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
32                }
33            }
34        }
35
36        return dp[n-1][m-1];
37    }
38}