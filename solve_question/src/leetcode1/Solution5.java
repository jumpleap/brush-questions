package leetcode1;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
class Solution5 {
    /**
     * 思路分析: 滑动窗口(同向双指针, 需具有单调性)
     * 使用left和right固定一个窗口, 然后计算这个窗口内的和, 判断这个和是否大于target, 大于则需要出窗口(left右移)
     * 每出一次窗口, 都需要计算这个窗口大小, 找到最小的一次窗口大小即为最小子数组的和
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        // 总和
        int sum = 0;
        // 最小子数组长度
        int minStep = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            // 进窗口
            sum += nums[right];

            // 判断
            while(sum >= target) {
                // 出窗口
                sum -= nums[left];
                // 计算子数组长度
                int step = right - left;
                // 比较, 小于则重置
                if(step < minStep) {
                    minStep = step;
                }
                // left右移, 防止重置sum
                left++;
            }
        }

        // 返回最小子数组长度
        return minStep == Integer.MAX_VALUE? 0: minStep + 1;
    }
}