1class Solution {
2    public int maxLength(int[] ribbons, int k) {
3        int length = ribbons.length;
4        long total_len = 0;
5        int max_elem = -1;
6        if(length==0){
7            return 0;
8        }
9        for(int i=0; i<length; i++){
10            total_len += ribbons[i];
11            max_elem = Math.max(ribbons[i], max_elem);
12        }
13        if(total_len < k){
14            return 0;
15        }
16        int l=1; //minimum length of ribbon possible.
17        int r = max_elem; //maximum length of ribbon possible.
18        int ans = 0;
19        while(l<=r){
20            int mid = l+(r-l)/2;
21            boolean isPossible = isThislengthPossible(ribbons, mid, k);
22            if(isPossible){
23                ans = mid;
24                l=mid+1; //try to increase length.
25            }else{
26                r=mid-1; //reduce length.
27            }
28        }
29        return ans;
30    }
31
32    boolean isThislengthPossible(int[] ribbons, int len, int k){
33        long count = 0;
34        for(int i=0; i<ribbons.length; i++){
35            count += ribbons[i]/len;
36        }
37        if(count >= k){
38            return true;
39        }
40        return false;
41    }
42}