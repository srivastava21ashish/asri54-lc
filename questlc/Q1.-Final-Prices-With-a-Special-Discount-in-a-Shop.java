1class Solution {
2    public int[] finalPrices(int[] prices) {
3        int l = prices.length;
4        int[] st = new int[l];
5        int p = -1;
6        for(int i=l-1; i>=0; i--){
7            int temp = prices[i];
8            while(p>-1 && prices[i] < st[p]){
9                st[p]=0;
10                p--;
11            }
12            if(p!=-1){
13                prices[i] = prices[i] - st[p];
14            }
15            st[++p] = temp;
16        }
17        
18        return prices;
19    }
20}