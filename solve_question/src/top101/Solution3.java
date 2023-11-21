package top101;

import util.ListNode;

import java.util.*;

/**
 *
 */

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution3 {
    /**
     * 思路分析: 快慢指针.
     * 使用快慢指针找到要删除的节点位置, 并使用一个指针指向要删除节点位置的前一个位置, 完成删除
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 定义哑节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 定义快慢指针
        ListNode slow = dummy;
        ListNode fast = dummy;

        // 让快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 让快慢指针一起走, 快指针结束的时候, 慢指针走到要删除的节点位置
        // 定义一个节点指向slow的前一个节点
        ListNode preSlow = slow;
        while (fast != null) {
            fast = fast.next;
            // preSlow指针总是指到slow的前一个位置
            preSlow = slow;
            slow = slow.next;
        }
        // 删除slow节点
        preSlow.next = slow.next;
        return dummy.next;
    }
}