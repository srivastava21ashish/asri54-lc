1class Solution {
2    public int[] exclusiveTime(int n, List<String> logs) {
3        int lastexec = 0;
4        Stack<Integer> st = new Stack<>();
5        int[] ans = new int[n];
6        for(String log:logs){
7            String[] tokens = log.split(":");
8            int fid = Integer.parseInt(tokens[0]);
9            int tokentime = Integer.parseInt(tokens[2]);
10            if(tokens[1].equals("start")){
11                if(!st.isEmpty()){
12                    ans[st.peek()]+=(tokentime-lastexec);
13                }
14                st.push(fid);
15                lastexec = tokentime;
16            }else{
17                ans[st.pop()]+=(tokentime-lastexec+1);
18                lastexec = tokentime+1;
19            }
20
21        }
22        return ans;
23    }
24}