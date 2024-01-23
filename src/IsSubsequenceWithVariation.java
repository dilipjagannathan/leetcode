import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IsSubsequenceWithVariation {
    public boolean isSubsequence(String s, String t) {

        HashMap<Character, List<Integer>> letterIndicesTable = new HashMap<>();
        for (int i = 0; i< t.length(); i++) {
            if (letterIndicesTable.containsKey(t.charAt(i))) {
                letterIndicesTable.get(t.charAt(i)).add(i);
            } else {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i);
                letterIndicesTable.put(t.charAt(i), indices);
            }
        }
        Integer currentMatchIndex = -1;
        for (char letter: s.toCharArray()) {
            if (!letterIndicesTable.containsKey(letter)) {
                return false;
            }

            boolean isMatched = false;
            for (Integer matchIndex: letterIndicesTable.get(letter)) {
                if (currentMatchIndex<matchIndex) {
                    currentMatchIndex = matchIndex;
                    isMatched = true;
                    break;
                }
            }

            if (!isMatched)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsSubsequence subsequence = new IsSubsequence();
        System.out.println(subsequence.isSubsequence("abc", "ahbgdc"));
        System.out.println(subsequence.isSubsequence("axc", "ahbgdc"));
    }
}
