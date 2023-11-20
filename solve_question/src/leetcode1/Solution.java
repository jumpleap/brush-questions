package leetcode1;

import java.util.*;
import java.util.Stack;

public class Solution {
    // 定义常规栈和最小栈
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        // 常规栈直接入元素
        stack.push(node);

        // 最小栈为空时直接入, 不为空需要和栈顶元素进行比较
        if (minStack.empty()) {
            minStack.push(node);
        } else if (minStack.peek() >= node) {
            minStack.push(node);
        }
    }

    public void pop() {
        // 常规栈直接出栈
        int popVal = stack.pop();

        // 若常规栈的出栈元素和最小栈的一样, 最小栈也要出栈
        if (popVal == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        // 返回常规栈的栈顶元素
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
