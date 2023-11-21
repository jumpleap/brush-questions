package top101;

import util.ListNode;

import java.util.*;

/**
 * 输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution2 {
    /**
     * 思路分析: 模拟.
     * 让长度最长的链表先走两个链表的差值步, 然后一起走, 相遇点即为公共交点
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        // 获取pHead1 和 pHead2的长度
        int size1 = getLength(pHead1);
        int size2 = getLength(pHead2);

        // 使用两个指针分别指向pHead1和pHead2
        // l1指向长度最长的链表, l2指向最短的链表
        ListNode l1 = pHead1;
        ListNode l2 = pHead2;

        // 判断size1 和 size2那个长
        int gap = size1 - size2; // 获取两个链表长度的差值
        // 若size2大于size1, 则l1和l2需要交换指向
        if (size1 < size2) {
            l1 = pHead2;
            l2 = pHead1;

            gap = -gap;
        }

        // 让链表最长的链表先走差值步
        for (int i = 0; i < gap; i++) {
            if (l1 == null) {
                return l1;
            }
            l1 = l1.next;
        }

        // 两个链表一起走, 相遇点即为公共交点
        while (l1 != null && l2 != null && l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        // 返回交点
        return l1;
    }


    // 计算链表长度
    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}