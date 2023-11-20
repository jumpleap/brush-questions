package leetcode1;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
class Solution6 {
    /**
     * 思路分析: 二分查找
     * 时间复杂度: O(logN)
     * 空间复杂度: O(1)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // 找到左右端点
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // 找中间值, 防止溢出
            int mid = left + (right - left) / 2;

            // 判断中间值和target的比较
            if (nums[mid] < target) {
                left = mid + 1; // 小于target, left右移
            } else if (nums[mid] > target) {
                right = mid - 1; // 大于target, right右移
            } else {
                return mid; // 找到了
            }
        }
        // 没有找到
        return -1;
    }
}