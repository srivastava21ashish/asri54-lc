1class Solution {
2    private static final String OPERATORS = "+-*/";
3    public int evalRPN(String[] tokens) {
4
5        Stack<Integer> st = new Stack<>();
6        for(String token : tokens){
7            if(OPERATORS.indexOf(token) == -1){
8                st.push(Integer.parseInt(token));
9            }else{
10                st.push(calculate(st.pop(), st.pop(), token.charAt(0)));
11            }
12        }
13        return st.pop();
14    }
15    int calculate(int op1, int op2, char operand){
16        switch(operand){
17            case '+':
18            return op1+op2;
19            case '-':
20            return op2-op1;
21            case '*':
22            return op1*op2;
23            case '/':
24            return op2/op1;
25        }
26        return 0;
27    }
28}