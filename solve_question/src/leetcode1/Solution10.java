package leetcode1;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 */
class Solution10 {
    /**
     * 思路分析: 快慢指针, 快指针每次走两步, 慢指针每次走一步
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        // 定义快慢双指针
        int slow = n;
        int fast = getSum(n);

        // 当快慢指针相同时, 则跳出循环
        while (fast != slow) {
            // 快指针每次走两步
            fast = getSum(getSum(fast));
            // 慢指针每次走一步
            slow = getSum(slow);
        }
        // 判断是否为1
        return fast == 1;
    }

    // 计算num中的每个位的平方和, 累加
    private int getSum(int num) {
        int sum = 0;

        while (num != 0) {
            // 获取余数
            int tmp = num % 10;
            // 累加
            sum += tmp * tmp;
            // 计算下一位余数
            num /= 10;
        }
        return sum;
    }
}