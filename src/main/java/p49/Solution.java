package p49;

import java.util.*;

/**
 * 49. 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class Solution {
    private static final int[] PRIMES = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 107};

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, List<String>> map = new HashMap<>();
        for (String str : strs) {
            long key = 1;
            for (char c : str.toCharArray()) {
                key *= PRIMES[c - 'a'];
            }

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private List<List<String>> s2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] c = new int[26];
        for (String str : strs) {
            Arrays.fill(c, 0);
            for (char c1 : str.toCharArray()) {
                c[c1 - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i : c) {
                sb.append("#").append(i);
            }

            String key = sb.toString();

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                ArrayList<String> values = new ArrayList<>();
                values.add(str);
                map.put(key, values);
            }
        }

        return new ArrayList<>(map.values());
    }

    private List<List<String>> s1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                ArrayList<String> values = new ArrayList<>();
                values.add(str);
                map.put(key, values);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] params = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new Solution().groupAnagrams(params);
        System.out.println(lists);
    }
}
