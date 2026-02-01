1class Solution {
2    public int[] dailyTemperatures(int[] temperatures) {
3        int l = temperatures.length;
4        int[] ans = new int[l];
5        int[] st = new int[l];
6        int p=-1;
7        for(int i=l-1; i>=0; i--){
8            while(p>-1 && temperatures[i] >= temperatures[st[p]]){
9                p--;
10            }
11            if(p==-1){
12                ans[i] = 0;
13            }else{
14                ans[i] = st[p]-i;
15            }
16            st[++p]=i;
17        }
18        System.gc();
19        return ans;
20    }
21}