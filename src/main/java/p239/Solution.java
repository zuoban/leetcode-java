package p239;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 239. 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are unless
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            // q contains index ... r contains content
            q.offer(i);

            if (i >= k - 1) {
                r[ri++] = nums[q.peek()];
            }
            System.out.println(q);
        }
        return r;
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 4,-1, -3, -4 , 5, 3, 6, 7};
//        int[] nums = new int[]{1, 3, -1, 5, 3, 6, 7};
        int[] nums = new int[]{5,4,3,2};
        int[] ints = new Solution().maxSlidingWindow(nums, 2);
        System.out.println(Arrays.toString(ints));
    }
}
