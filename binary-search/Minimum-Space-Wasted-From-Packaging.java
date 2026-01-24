1class Solution {
2    int MOD = 1000000007;
3    public int minWastedSpace(int[] packages, int[][] boxes) {
4
5        // Sort each supplier's boxes
6        for (int[] row : boxes) {
7            Arrays.sort(row);
8        }
9
10        // Sort packages
11        Arrays.sort(packages);
12
13        int packlen = packages.length;
14
15        // Prefix sum
16        long[] psum = new long[packlen + 1];
17        for (int i = 0; i < packlen; i++) {
18            psum[i + 1] = psum[i] + packages[i];
19        }
20
21        int largestPack = packages[packlen - 1];
22        long minwastage = Long.MAX_VALUE;
23
24        for (int[] row : boxes) {
25
26            // If supplier cannot fit the largest package
27            if (row[row.length - 1] < largestPack) continue;
28
29            long twastage = 0;
30            int lastCovered = -1;
31
32            for (int boxSize : row) {
33
34                int idx = findIndexLargestPack(boxSize, packages);
35
36                if (idx <= lastCovered) continue;
37
38                // packages covered: (lastCovered + 1) .. idx
39                int count = idx - lastCovered;
40                long sumPackages = psum[idx + 1] - psum[lastCovered + 1];
41
42                twastage += (long) boxSize * count - sumPackages;
43
44                lastCovered = idx;
45
46                if (lastCovered == packlen - 1) break;
47            }
48
49            if (lastCovered == packlen - 1) {
50                minwastage = Math.min(minwastage, twastage);
51            }
52        }
53
54        return minwastage == Long.MAX_VALUE ? -1 : (int)(minwastage % MOD);
55        
56    }
57
58    int findIndexLargestPack(int size, int[] packages){
59        int l=0,r=packages.length-1;
60        int ans = -1;
61        while(l<=r){
62            int mid = l+(r-l)/2;
63            if(packages[mid] <= size){
64                ans = mid;
65                l=mid+1;
66            }else{
67                r=mid-1;
68            }
69        }
70        return ans;
71    }
72}