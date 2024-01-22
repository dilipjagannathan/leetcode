public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        Integer sourceLength = s.length(), targetLength = t.length();

        Integer i = 0, j = 0;

        while (i < sourceLength && j < targetLength) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == sourceLength;
    }

    public static void main(String[] args) {
        IsSubsequence subsequence = new IsSubsequence();
        System.out.println(subsequence.isSubsequence("abc", "ahbgdc"));
        System.out.println(subsequence.isSubsequence("axc", "ahbgdc"));
    }
}
