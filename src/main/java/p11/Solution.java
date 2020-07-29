package p11;

/**
 * 11. 盛最多水的容
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * 1. 枚举 left bar x, right bar y (x-y) * height_diff  O(n^2)
 *
 * 2. O(N), 左右边界 i, j ，向中间收敛：左右夹逼
 *
 */
public class Solution {
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;

        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        if (height.length < 2) return 0;
        int max = 0;

        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight;
            max = Math.max(area, max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution().maxArea2(heights));
    }
}
