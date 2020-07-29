package p70;

/**
 * 70. 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <pre>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * </pre>
 * 示例 2：
 * <pre>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * </pre>
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class Solution {
    /**
     * 懵逼的时候：
     * 暴力？ 基本情况?
     * 找 最近 重复子问题
     * if else, for while, recursion
     * <p>
     * 1: 1
     * 2: 3
     * 3:  f(1) + f(2)
     * 4: f(2) + f(3)
     * <p>
     * f(n) = f(n-1) + f(n-2): Fibonacci
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int f1 = 1, f2 = 2, f3 = 3;

        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }

        return f3;
    }

    public static void main(String[] args) {
        int result = new Solution().climbStairs(10);
        System.out.println(result);
    }
}
