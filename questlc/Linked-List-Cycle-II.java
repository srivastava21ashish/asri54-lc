1public class Solution {
2    public ListNode detectCycle(ListNode head) {
3        ListNode slow = head;
4        ListNode fast = head;
5        boolean hasCycle = false;
6
7        while (fast != null && fast.next != null) {
8            slow = slow.next;
9            fast = fast.next.next;
10
11            if (slow == fast) {
12                hasCycle = true;
13                break;
14            }
15        }
16
17        if (!hasCycle) return null;
18
19        slow = head;
20
21        while (slow != fast) {
22            slow = slow.next;
23            fast = fast.next;
24        }
25
26        return slow;
27    }
28}