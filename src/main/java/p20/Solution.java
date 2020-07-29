package p20;

import java.util.Stack;

/**
 * 20. 有效的括号
 * <p>
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty())  return false;
            else if (c != stack.pop()) return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("]"));
    }
}
