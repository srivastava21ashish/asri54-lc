1class Solution {
2    public List<String> buildArray(int[] target, int n) {
3        //int l = target.length;
4        List<String> ans = new ArrayList<>();
5        
6        int i=0,k=1;
7        while(i<target.length && k<=n){
8            ans.add("Push");
9            if(k==target[i]){
10                i++;
11                k++;
12            }else{
13                ans.add("Pop");
14                k++;
15            }
16        }
17        return ans;
18    }
19}