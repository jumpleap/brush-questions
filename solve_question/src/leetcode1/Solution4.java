package leetcode1;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
class Solution4 {
    /**
     * 思路分析: 双指针.
     * left指向非0元素的最后一个位置, right遇见0元素则和left进行交换
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // 定义双指针
        int left = 0;
        int right = 0;
        for (; right < nums.length; right++) {
            // 若遇见非0元素则交换左右指针, 左指针右移
            if (nums[right] != 0) {
                int tmp = nums[left];
                nums[left++] = nums[right];
                nums[right] = tmp;
            }
        }
    }
}