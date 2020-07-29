package p1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] towSum(int[] nums, int target) {
        //  <item, index>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int expected = target - nums[i];
            if (map.containsKey(expected)) {
                return new int[]{map.get(expected), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

    }
}
