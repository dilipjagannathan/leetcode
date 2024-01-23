import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TwoCloseStrings {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        HashMap<Character, Integer> word1Map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> word2Map = new HashMap<Character, Integer>();
        for (Character c: word1.toCharArray()) {
            word1Map.put( c, word1Map.getOrDefault(c, 0)+1);
        }

        for (Character c: word2.toCharArray()) {
            word2Map.put( c, word2Map.getOrDefault(c, 0)+1);
        }

        if(!word1Map.keySet().equals(word2Map.keySet())){
            return false;
        }

        ArrayList<Integer> l1=new ArrayList<>(word1Map.values());
        ArrayList<Integer>l2=new ArrayList<>(word2Map.values());

        if(l1.size()!=l2.size()){
            return false;
        }

        Collections.sort(l1);
        Collections.sort(l2);

        return l1.equals(l2);

    }
}
