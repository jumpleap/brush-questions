package test;

/*
给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 */
public class Demo1 {
    /**
     * 思路分析: 使用数组的第一个元素分别和数组的其他元素进行异或, 得到的结果就是数组中只出现一次的数
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param nums 给定的数组
     * @return 返回数组中只出现一次的数字
     */
    public int singleNumber(int[] nums) {
        // 取数组的第一个元素
        int ret = nums[0];
        // 数组长度
        int len = nums.length;
        // 遍历数组,异或其他元素
        for (int i = 1; i < len; i++) {
            ret ^= nums[i];
        }
        // 返回异或后的数据
        return ret;
    }
}
