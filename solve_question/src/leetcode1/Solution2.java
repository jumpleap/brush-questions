package leetcode1;

import util.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution2 {
    /**
     * 思路分析: 快慢指针
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        // 定义快慢指针
        ListNode slow = head;
        ListNode fast = head;

        // 循环判断
        while (fast != null && fast.next != null) {
            // 快指针每次走两步, 慢指针每次走一步
            fast = fast.next.next;
            slow = slow.next;

            // 当有环时, 则会相遇
            if (fast == slow) {
                return true;
            }
        }
        // 若是跳出循环, 则说明没有环
        return false;
    }
}