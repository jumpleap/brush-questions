package top101;

import util.ListNode;
/**
 * 给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
 */

import java.util.*;

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution1 {
    /**
     * 思路分析: 快慢指针 + 重置 + 遍历
     * 快慢指针: fast 每次走两步, slow每次走一步, 找到相遇点
     * 重置: 让fast = pHead, 把fast重置
     * 遍历: fast 和 slow一起走, 每次走一步, 相等即为入环点
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // 定义快慢指针
        ListNode slow = pHead;
        ListNode fast = pHead;

        // 找到相遇点
        while (fast != null && fast.next != null) {
            // 快指针每次走两步
            fast = fast.next.next;
            //慢指针每次走一步
            slow = slow.next;

            // 相遇判断
            if (fast == slow) {
                break;
            }
        }

        // 不存在相遇点, 即无环的情况
        if (fast == null || fast.next == null) {
            return null;
        }

        // 存在相遇点, 把fast重指向pHead
        fast = pHead;

        // fast 和 slow 一人走一步, 相遇点为入环点
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        // 返回入环点
        return slow;
    }
}