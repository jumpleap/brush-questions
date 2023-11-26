package top101;

import java.util.*;

/**
 * 大家都知道斐波那契数列，现在要求输入一个正整数 n ，请你输出斐波那契数列的第 n 项。
 */

public class Solution7 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 思路分析: 迭代法, 递归法
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param n int整型
     * @return int整型
     */
    public int Fibonacci(int n) {
        // 使用迭代法
        int n1 = 1;
        int n2 = 1;
        int sum = 1;

        // 当n不大于2后则跳出循环
        while (n > 2) {
            // sum 用于计算两则之和
            sum = n1 + n2;
            // 进行迭代
            n1 = n2;
            n2 = sum;

            n--;
        }
        // 返回结果
        return sum;
    }

    // 递归
    public int Fibonacci1(int n) {
        // 递归解法, 时间复杂度过大, 不建议
        if (n == 1 || n == 2) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}