1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode reverseBetween(ListNode head, int left, int right) {
13        ListNode dummy = new ListNode(-1);
14        dummy.next = head;
15        ListNode leftTail = dummy;
16        ListNode curr = dummy;
17        int i=1;
18        while(i<left){
19            leftTail = leftTail.next;
20            i++;
21        }
22        ListNode subHead = leftTail.next; //head to reverse.
23        ListNode subEnd = subHead;
24        while(i<right){
25            subEnd = subEnd.next;
26            i++;
27        }
28        ListNode rightHead = subEnd.next;
29        //detach list
30        subEnd.next = null;
31
32        //reverse list
33        ListNode prev = null;
34        ListNode c = subHead;
35        while(subHead != null){
36            ListNode nn = subHead.next;
37            subHead.next = prev;
38            prev = subHead;
39            subHead = nn;
40        }
41
42        leftTail.next = prev;
43        c.next = rightHead;
44        return dummy.next;
45    }
46}