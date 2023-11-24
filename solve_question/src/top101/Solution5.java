package top101;

import java.util.*;

/**
 * 给一个长度为 n 的数组，数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 */
public class Solution5 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 思路分享: 摩尔投票法, 谁多则最后的结果是谁
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int MoreThanHalfNum_Solution(int[] numbers) {
        // write code here
        // 计数器. 计算当前数字出现的次数
        int count = 1;
        // 目标值
        int target = numbers[0];

        // 遍历
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == target) {
                // 值相同, 则计数器自增
                count++;
            } else if (count == 0) {
                // count 为0, 则需要替换目标值
                target = numbers[i];
                count = 1;
            } else {
                // 上述都不是, 则计数器自减
                count--;
            }
        }
        // 返回目标值, 即出现次数最多的值
        return target;
    }
}