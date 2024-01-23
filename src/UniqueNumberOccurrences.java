import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) != null) {
                map.put(arr[i],map.get(arr[i])+1);
            } else {
                map.put(arr[i],1);
            }
        }
        boolean isUnique = true;
        HashSet<Integer> set = new HashSet<>();
        for (Integer key: map.keySet()) {
            if (set.contains(map.get(key))) {
                return false;
            } else {
                set.add(map.get(key));
            }
        }

        return true;
    }
}
