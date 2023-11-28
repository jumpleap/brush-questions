package top101;

import util.ListNode;
/**
 * 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
 */
import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution8 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 思路分析: 模拟
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 只有一个节点或一个节点也没有的情况
        if (head == null || head.next == null) {
            return head;
        }

        ListNode left = head;
        ListNode right = head.next;
        ListNode newHead = head;

        while (right != null) {
            // 值相等, 则需要跳过当前的right
            while (right != null && left.val == right.val) {
                right = right.next;
            }
            // 值不相等, 把left和right进行连接
            left.next = right;
            // 当right为空, 直接跳出循环, 防止空指针异常
            if (right == null) break;
            // 继续进行下一次的判断
            left = left.next;
            right = right.next;
        }
        // 返回新的头节点
        return newHead;
    }
}