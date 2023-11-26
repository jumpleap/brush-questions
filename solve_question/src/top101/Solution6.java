package top101;

import java.util.*;

/**
 * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。
 * 例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
 */

public class Solution6 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 思路分析: 使用优先级队列进行模拟(堆)
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * @param input int整型一维数组
     * @param k     int整型
     * @return int整型ArrayList
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        // 定义优先级队列, 以大根堆的方式进行创建
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return o1 - o2;
        });

        // 往queue中入值, 此时队列中的值是小数在上
        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
        }


        // 定义集合
        ArrayList<Integer> list = new ArrayList<>();
        // 计数器, 判断要多少个值入到集合中
        int index = 0;
        // 队列不为空, 则把队列中的元素全部放到集合中
        while (!queue.isEmpty() && index < k) {
            list.add(queue.poll());
            index++;
        }
        return list;
    }
}