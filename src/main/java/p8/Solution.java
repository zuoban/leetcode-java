package p8;

public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] chars = str.trim().toCharArray();
        int i = 0, j = 1, res = 0;

        for (; i < chars.length; i++) {
            if (chars[i] == '-') {
                j = -1;
            } else if (chars[i] == '+') {
                j = 1;
            } else if (Character.isDigit(chars[i])) {
                int num = chars[i] - '0';
                // res * 10 + num > int.max_value
                if (res > (Integer.MAX_VALUE - num) / 10) {
                    return j == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                res = res * 10 + (chars[i] - '0');
            } else {
                break;
            }
        }
        return res * j;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(Integer.MAX_VALUE);
        System.out.println(new Solution().myAtoi("+-2"));
    }
}
