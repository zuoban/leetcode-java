package p42;

import java.util.Stack;

/**
 * 42. 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Solution {
    public int trap(int[] height) {
        int curr = 0, sum = 0;
        Stack<Integer> stack = new Stack<>();

        while (curr < height.length) {
            //  若当前栈非空且 height[curr] > stack.peek()
            while (!stack.isEmpty() && height[curr] > height[stack.peek()]) {
                //弹出栈顶元素。
                int h = height[stack.pop()];
                if (stack.isEmpty()) break;

                // 计算当前元素和栈顶元素的距离
                int distance = curr - stack.peek() - 1;
                // 找出界定高度 ((left, curr 的最小高度) -  当前栈顶的高度)
                int boundedHeight = Math.min(height[stack.peek()], height[curr]) - h;
                // 计算面积,并累加
                sum += distance * boundedHeight;
            }
            stack.push(curr);
            curr++;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = new Solution().trap(arr);
        System.out.println(result);

        System.out.println(result == 6);
    }
}
