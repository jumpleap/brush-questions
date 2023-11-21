package leetcode1;

/**
 * 给你一个长度固定的整数数组 arr ，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 */
class Solution8 {
    /**
     * 思路分析: 双指针 + 模拟
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param arr
     */
    public void duplicateZeros(int[] arr) {
        int cur = 0;
        int dest = -1;

        // 用于查找复写的位置
        while (cur < arr.length) {
            // cur对应的值为0 ,则dest跳两次
            if (arr[cur] == 0) {
                dest += 2;
            } else {
                // 跳一次
                dest++;
            }

            // dest到达了最后一个元素的位置
            if (dest >= arr.length - 1) {
                break;
            }
            cur++;
        }

        // 边界处理, 为了防止dest重写的下标超过了数组长度
        if (dest >= arr.length) {
            dest -= 2;
            arr[arr.length - 1] = 0;
            cur--;
        }

        // 从后往前开始进行复写
        while (cur >= 0) {
            if (arr[cur] == 0) {
                arr[dest--] = 0;
                arr[dest--] = 0;
            } else {
                arr[dest--] = arr[cur];
            }
            cur--;
        }
    }
}