import java.math.BigDecimal;
import java.math.BigInteger;

public class GreatestCommonDivisorOfStrings {
/*    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        for (int i = Math.min(len1, len2); i>=1; i--) {
            if (valid(str1, str2, i)) {
                return str1.substring(0,i);
            }
        }
        return "";
    }

    private boolean valid(String str1, String str2, int i) {
        int len1 = str1.length(), len2 = str2.length();
        if (len1 % i > 0 || len2 % i > 0) {
            return false;
        } else {
            String base = str1.substring(0, i);
            return str1.replaceAll(base, "").isEmpty() && str2.replaceAll(base,"").isEmpty();
        }
    }*/

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcdLength = gcd(str1.length(), str2.length());


        return str1.substring(0, gcdLength);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
