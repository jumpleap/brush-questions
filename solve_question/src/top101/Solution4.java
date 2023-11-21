package top101;

import java.util.*;

/**
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 */

public class Solution4 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 思路分析: 使用栈进行模拟.
     * 情况1: 全部都是右括号的情况: )]}
     * 情况2: 括号乱匹配的问题: ([)]
     * 情况3: 全部都是左括号的问题: ([{
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        // 定义栈
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 判断当前ch是左括号还是右括号
            if (ch == '[' || ch == '{' || ch == '(') {
                // 左括号就入栈
                stack.push(ch);
            } else {
                // 是右括号
                // 先判断栈是否为空, 栈空返回false
                if (stack.empty()) {
                    return false;
                }

                // 栈不为空, 则判断栈顶元素是否和这个ch的字符匹配
                char tmp = stack.peek();
                if ((tmp == '(' && ch == ')') || tmp == '[' && ch == ']' || (tmp == '{' && ch == '}')) {
                    // 匹配就出栈
                    stack.pop();
                } else {
                    // 不匹配
                    return false;
                }
            }
        }
        // 全部都是左括号的情况,也需要判断
        // 若是全部匹配, 则说明栈为空
        return stack.empty();
    }
}