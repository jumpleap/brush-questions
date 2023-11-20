package leetcode1;

public class Solution7 {
    // 二分查找的模板
    /*public int search(int[] nums, int target) {
        // 找到左右端点
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // 找中间值, 防止溢出
            int mid = left + (right - left) / 2;

            // 判断中间值和target的比较
            if (.....) {
                left = mid + 1; // 小于target, left右移
            } else if .....) {
                right = mid - 1; // 大于target, right右移
            } else {
                return ....; // 找到了
            }
        }
        // 没有找到
        return -1;
    }*/
}
