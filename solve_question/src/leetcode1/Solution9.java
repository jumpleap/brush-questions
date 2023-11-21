package leetcode1;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 */
class Solution9 {
    /**
     * 思路分析: 滑动窗口 + 哈希表
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param str
     * @return
     */
    public int lengthOfLongestSubstring(String str) {
        // 申请空间
        int[] arr = new int[128];
        // 定义双指针
        int left = 0, right = 0;
        int len = str.length();
        // 获取最后的结果
        int ret = 0;

        while (right < len) {
            // 进窗口
            arr[str.charAt(right)]++;
            // 说明遇见了重复的字符, 把重复的字符全部删掉
            while (arr[str.charAt(right)] > 1) {
                // 出窗口(把左指针对应的值出了, 再让左指针右移)
                arr[str.charAt(left)]--;
                left++;
            }
            // 比较当前子串的长度和ret那个长
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }
}