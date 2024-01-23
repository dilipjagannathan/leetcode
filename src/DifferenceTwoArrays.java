import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DifferenceTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1Set = new HashSet();
        HashSet<Integer> nums2Set = new HashSet();

        for (int i: nums1){
            nums1Set.add(i);
        }

        for (int i: nums2){
            nums2Set.add(i);
        }

        Set<Integer> result1 = new HashSet<>();
        Set<Integer> result2 = new HashSet<>();

        for (int i: nums1){
            if (!nums2Set.contains(i)) {
                result1.add(i);
            }
        }

        for (int i: nums2){
            if (!nums1Set.contains(i)) {
                result2.add(i);
            }
        }
        List<Integer> result1List = new ArrayList<>(result1);
        List<Integer> result2List = new ArrayList<>(result2);
        return List.of(result1List, result2List);
    }
}
