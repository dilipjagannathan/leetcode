public class MaxVowelsInSubstringK {
    // Return true if the character is a vowel (case-insensitive)
    boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u';
    }
    public int maxVowels(String s, int k) {
        int numberOfVowels = 0;
        int length = s.length();
        for (int i =0; i <k; i++) {
            if (isVowel(s.charAt(i))) {
                numberOfVowels += 1;
            }
        }
        int result = numberOfVowels;
        for (int i=k; i<length; i++) {
            if (isVowel(s.charAt(i))) {
                numberOfVowels +=1;
            }
            if (isVowel(s.charAt(i-k))) {
                numberOfVowels -=1;
            }
            result = Math.max(result, numberOfVowels);
        }

        return result;
    }
}
