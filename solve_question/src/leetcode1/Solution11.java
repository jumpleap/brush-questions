package leetcode1;

/**
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 */
class Solution11 {
    /**
     * 思路分析: 滑动窗口
     * 滑动窗口套路:
     * 1) left = 0, right = 0
     * 2) 进窗口
     * 3) 判断, 且根据判断出窗口, 一般是个循环
     * 4) 更新结果, 更新结果一般在判断中或判断结束后更新结果
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        // 定义双指针
        int left = 0;
        int right = 0;
        // 定义0计数器
        int zero = 0;
        // 返回结果
        int max = 0;

        while (right < nums.length) {
            // 进窗口
            if (nums[right] == 0) {
                zero++;
            }

            // 出窗口
            while (zero > k) {
                // 遇到0则需要把zero--
                if (nums[left] == 0) {
                    zero--;
                }
                // left 右移
                left++;
            }

            // 更新结果
            max = Math.max(max, right - left + 1);
            right++;
        }
        // 返回结果
        return max;
    }
}