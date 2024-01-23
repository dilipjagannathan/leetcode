import java.util.HashMap;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int i=0; i< nums.length; i++) {
            int value = nums[i];
            int complement = k - value;
            if (map.getOrDefault(complement, 0) > 0) {
                map.put(complement, map.get(complement) - 1);
                count++;
            } else {
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
        }

        return count;

    }
}
