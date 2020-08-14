package p242;


import cn.hutool.core.lang.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/description/
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] ++;
            arr[t.charAt(i) - 'a'] --;
        }

        for (int value : arr) {
            if (value != 0) return false;
        }

        return true;
    }

    /**
     * hashmap
     *
     * @param s
     * @param t
     * @return
     */
    private boolean solution2(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int tmp = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), tmp + 1);

            tmp = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), tmp - 1);
        }

        for (Integer value : map.values()) {
            if (value != 0) return false;
        }

        return true;
    }

    /**
     * sort + equals
     *
     * @return
     */
    private boolean solution1(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        return Arrays.equals(sCharArray, tCharArray);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.isAnagram("anagram", "nagaram");
        Assert.isTrue(result);
        result = solution.isAnagram("rat", "car");
        Assert.isFalse(result);
    }
}

