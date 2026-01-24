1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        int n1 = nums1.length;
4        int n2 = nums2.length;
5        if(n1 < n2){
6            return findMedianSortedArrays(nums2, nums1);
7        }
8        if(n2==0){
9            if(n1%2 != 0){
10                return nums1[n1/2];
11            }else{
12                int a = n1/2;
13                return (nums1[a-1]+nums1[a] + 0.0)/2;
14            }
15        }
16        double ans = -1;
17        int N = n1+n2;
18        int target = N%2 == 0 ? N/2 : (N+1)/2;
19
20        int l=0,r=target;
21        while(l<=r){
22            int mid = l+(r-l)/2;
23            //need mid number of elements from nums1, rest from nums2
24            int al = mid-1>=0 && mid-1 < n1 ? nums1[mid-1] : Integer.MIN_VALUE;
25            int ar = mid<n1 ? nums1[mid]: Integer.MAX_VALUE;
26            int remaining = target - mid;
27            int bl = remaining-1 >=0 && remaining -1 < n2 ? nums2[remaining-1] : Integer.MIN_VALUE;
28            int br = remaining < n2 ? nums2[remaining] : Integer.MAX_VALUE;
29
30            if(al <= br && bl <= ar){
31                //found the answer
32                if(N%2!=0){
33                    ans = (double)Math.max(al,bl);
34                    
35                }else{
36                    ans = (Math.max(al,bl)+Math.min(ar,br)+0.0)/2;
37                }
38                l=mid+1;
39            }else if(bl > ar){
40                //decrement from b. means go right.
41                l=mid+1;
42            }else{
43                //al > br
44                //go left
45                r=mid-1;
46            }
47        }
48        return ans;
49        
50    }
51}