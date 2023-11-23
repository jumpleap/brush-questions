package leetcode1;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求该后缀表达式的计算结果。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 */

class Solution12 {
    /**
     * 栈 + 模拟
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        // 定义栈
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (!isOperation(s)) {
                // 不是运算符
                stack.push(Integer.parseInt(s));
            } else {
                // 是运算符

                // 获取左右操作数
                int right = stack.pop();
                int left = stack.pop();

                // 判断s是那个运算符
                switch (s) {
                    case "+":
                        stack.push(left + right);
                        break;
                    case "-":
                        stack.push(left - right);
                        break;
                    case "*":
                        stack.push(left * right);
                        break;
                    case "/":
                        stack.push(left / right);
                        break;
                }
            }
        }

        return stack.pop();
    }

    // 判断是不是运算符
    private boolean isOperation(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}