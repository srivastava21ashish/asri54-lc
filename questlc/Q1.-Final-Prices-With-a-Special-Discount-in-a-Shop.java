1class Solution {
2    public int[] finalPrices(int[] prices) {
3        int l = prices.length;
4        int[] nsr = new int[l];
5        Stack<Integer> st = new Stack<>();
6        nsr[l-1] = prices[l-1];
7        for(int i=l-1; i>=0; i--){
8            while(!st.isEmpty() && prices[i] < prices[st.peek()]){
9                st.pop();
10            }
11            if(st.isEmpty()){
12                nsr[i] = prices[i];
13            }else{
14                nsr[i] = prices[i]-prices[st.peek()];
15            }
16            st.push(i);
17        }
18        return nsr;
19    }
20}